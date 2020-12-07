package request;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author WangYao
 * @date 2020/10/26
 * @function 将文件放到网上让别人下载
 */
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
         * 1.获取下载文件路径
         * 2.获取下载文件名
         * 3.浏览器支持该文件(Content-Disposition)
         * 4.获取文件输入流
         * 5.创建缓存区
         * 6.获得OutputStream对象
         * 7.将其写入缓存区
         * 8.使用它将缓存区内容输出到客户端
         */
        String realPath = "F:\\servletandjsp\\response\\src\\main\\resources\\lina.jpg";
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        resp.setHeader("Content-Disposition", "attachment; filename="+fileName);
        FileInputStream in = new FileInputStream(realPath);
        int len = 0;
        byte[] buffer = new byte[1024];
        ServletOutputStream out = resp.getOutputStream();
        while((len = in.read(buffer)) != -1){
            out.write(buffer, 0, len);
        }
        in.close();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
