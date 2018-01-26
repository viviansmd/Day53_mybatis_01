package com.ssm.service.impl;

import com.ssm.domain.BaseResult;
import com.ssm.domain.Page;
import com.ssm.domain.Student;
import com.ssm.mapper.StudentMapper;
import com.ssm.page.PageBean;
import com.ssm.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 18/1/26.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    /*service调持久层对象*/
    @Resource
    private StudentMapper studentMapper;

    /*查询所有*/
    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    @Override
    public BaseResult<Student> selectPage(int pageIndex, int pageSize,Student student) {
        BaseResult<Student> result = new BaseResult<Student>();
        PageBean<Student> pg = new PageBean<Student>();
        pg.setParameter(student);
        int total = studentMapper.getTotalRecord(pg);//总条数
        PageBean<Student> pageBean = new PageBean<Student>(pageIndex+1,pageSize,total);//构建分页对象
        pageBean.setParameter(student);//更新分页查询中的参数
        List<Student> datas = studentMapper.selectPage(pageBean);//获取当前页数据
        result.setTotal(total);//将总记录数与当前页data数据设置到BaseResult对象中
        result.setData(datas);
        return result;
    }

}
