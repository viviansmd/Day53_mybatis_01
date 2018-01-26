package com.ssm.service;

import com.ssm.domain.BaseResult;
import com.ssm.domain.Page;
import com.ssm.domain.Student;

import java.util.List;

/**
 * Created by dllo on 18/1/26.
 */
public interface StudentService {
    List<Student> selectAll();

    /**
     * 分页查询
     * 根据前端传来的值
     *
     * @param pageIndex 页码 从0开始
     * @param pageSize  每页显示的条数
     * @param student   包含条件查询的参数对象
     * @return 返回包含total和data的结果封装对象
     **/
    BaseResult<Student> selectPage(int pageIndex, int pageSize, Student student);
}
