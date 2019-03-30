package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.service.Impl.CategoryServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.rngom.parse.host.Base;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author xieren8iao
 * @create 2019/3/27 - 20:11
 */
@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {
    //业务对象
    private CategoryService service=new CategoryServiceImpl();

    /**
     * 查找所有分类信息
     * @param request
     * @param response
     * @throws IOException
     */
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //查询
        List<Category> list = service.findAll();
        //封装成json
        /*response.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper=new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), list);*/
        WriteValue(list, response);
//        System.out.println(list);

    }

}
