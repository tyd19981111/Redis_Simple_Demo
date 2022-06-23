package com.tyd;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tyd.entity.Province;
import com.tyd.service.ProvinceService;
import com.tyd.service.impl.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/provinceServlet")
public class ProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //方式一：访问数据库查询数据
//        ProvinceService service = new ProvinceServiceImpl();
//        List<Province> list = service.findAll();
//        //序列化list为json
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(list);
//        //System.out.println(json);
//        //响应结果
//        response.setContentType("application/json;charset=utf-8");
//        response.getWriter().write(json);

        //方式二：使用redis缓存读取数据
        ProvinceService service = new ProvinceServiceImpl();
        String json = service.findAllJson();
        System.out.println(json);
        //3.响应结果
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
