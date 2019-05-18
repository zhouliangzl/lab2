package servlet.user;

import services.AdService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/manageAd")
public class ManageAdServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdService adService=new AdService();
        int[] adposs=new int[2000];
        int[] adposStatus=new int[2000];
        try {
            adposs=adService.getAllAdpos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int[] apid=new int[2000];
        try {
            apid = adService.getAllApid();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int k=0;

        for(int i=0;i<adposs.length;i++) {
            for (int j=0;j<apid.length;j++) {
                if(adposs[i]==apid[j]&&adposs[i]!=0) {
                    adposStatus[k]=1;
                    break;
                }
                else if (apid[j]==0) {
                    adposStatus[k]=0;
                    break;
                }
                else {
                    continue;
                }
            }
            k++;
        }

        request.setAttribute("adposs",adposs);
        request.setAttribute("adposStatus",adposStatus);
        request.getRequestDispatcher("/JSP/user/manageAdpos.jsp").forward(request,response);
    }
}
