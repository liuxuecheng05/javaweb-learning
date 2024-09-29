package com.example.class03response;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

@WebServlet("/res")
public class ResponseTypeDemo extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        switch (type) {
            case "html":
                getHtml(resp);
                break; // 添加 break
            case "json":
                getJson(resp); // 修改为 resp
                break; // 添加 break
            case "img":
                getImage(req, resp);
                break;
            case "pdf":
                getPdf(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid type parameter");
                break; // 添加 break
        }
    }

    private void getHtml(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html lang=\"en\"><body>"); // 修正 HTML 输出
        out.println("<h1>响应HTML内容</h1>");
        out.println("</body></html>");
        out.flush();
        out.close();
    }

    protected void getImage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/png");
        String path = req.getServletContext().getRealPath("");
        File file = new File(path + "/images/image.png"); // 确保路径拼接正确
        InputStream in = new FileInputStream(file);
        int read;
        ServletOutputStream out = resp.getOutputStream();
        while ((read = in.read()) != -1) {
            out.write(read);
        }
        out.flush();
        in.close(); // 关闭输入流
        out.close(); // 关闭输出流
    }

    private void getPdf(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        String path = request.getServletContext().getRealPath("");
        File file = new File(path + "/pdf/java期末.pdf");
        InputStream in = new FileInputStream(file);
        int read=0;
        ServletOutputStream out = response.getOutputStream();
        while ((read = in.read()) != -1) {
            out.write(read);
        }
        out.flush();
        in.close();
        out.close();
    }

    private void getJson(HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        String json = "{\n" +
                "  \"msg\": \"success\",\n" +
                "  \"data\": {\n" +
                "    \"bookName\": \"学习问答\",\n" +
                "    \"cover\": \"http://p2.img.cctvpic.com/photoAlbum/page/performance/img/2021/3/30/1617083963025_537.jpg\"\n" +
                "  }\n" +
                "}";

        out.println(json);
        out.flush();
        out.close();
    }
}