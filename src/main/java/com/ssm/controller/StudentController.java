package com.ssm.controller;

import com.ssm.domain.BaseResult;
import com.ssm.domain.Student;
import com.ssm.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 18/1/25.
 */
@Controller
public class StudentController {

    /*声明service层中的对外接口对象*/
    @Resource
    private StudentService studentService;


    /*获取学生列表,用于前端页面表格显示
    请求的数据不是页面,用ResponseBody*/
    @RequestMapping("/searchStudent")
    @ResponseBody
    public BaseResult<Student> searchStudent(){
        List<Student> students = studentService.selectAll();

        /*将查询到的结果集进行封装*/
        BaseResult<Student> result = new BaseResult<Student>();
        result.setTotal(100);//设置总记录数
        result.setData(students);//设置当页显示的数据

        return result;
    }

    /*分页查询
    * int pageIndex,int pageSize
    * miniui前端传递过来的参数
    * student接收前端页码传递过来的参数*/
    @RequestMapping(value = "/findStudent")
    @ResponseBody
    public BaseResult<Student> findStudent(int pageIndex,int pageSize,Student student){
        //调用分页查询业务
        BaseResult<Student> result = studentService.selectPage(pageIndex,pageSize,student);
        return result;
    }

    /**配置起始页**/
    @RequestMapping(value = {"","/"})
    public String index(){
        return "index";
    }


}
