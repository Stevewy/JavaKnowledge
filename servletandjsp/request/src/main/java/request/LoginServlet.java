package request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author WangYao
 * @date 2020/11/2
 * @function 获得前端的参数 请求转发
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String[] types = req.getParameterValues("type");
        System.out.println(Arrays.toString(types));

        // context 转发
        // response 转发 重定向
        req.getRequestDispatcher("/WEB-INF/success.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
        doGet(req, resp);
    }
}
