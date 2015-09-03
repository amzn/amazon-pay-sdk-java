import PayWithAmazon.IPNHandler;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class ipn_handler extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        String messagetype = request.getHeader("x-amz-sns-message-type");
        //If message doesn't have the message type header, don't process it.
        //if (messagetype == null)
            //return;

        // Parse the JSON message in the message body
        // and populate the IPNMessage object with its contents 
        // so that we have easy access to the name/value pairs 
        // from the JSON message.
        Scanner scan = new Scanner(request.getInputStream());
        StringBuilder builder = new StringBuilder();
        while (scan.hasNextLine()) {
            builder.append(scan.nextLine());
        }
              
       IPNHandler ipn = new IPNHandler(builder.toString());

       out.println( ipn.getIpnMessageAsJSON() + "<br/><br/>" );
       out.println( "Environment" + ipn.getEnvironment() );
       out.println( "Message" + ipn.getMessage());
       out.println( "MessageId" + ipn.getMessageId());
       out.println( "MessageTimeStamp" + ipn.getMessageTimeStamp());
       out.println( "NotificationData" + ipn.getNotificationData());
       out.println( "NotificationType" + ipn.getNotificationType());
       out.println( "SellerId" + ipn.getSellerId() );
       out.println( "SignatureVersion" + ipn.getSignatureVersion() );
       out.println( "SigningCertURL" + ipn.getSigningCertURL() );
       out.println( "Timestamp" + ipn.getTimestamp() );
       out.println( "Version" + ipn.getVersion() );
       out.println( "TopicArn" + ipn.getTopicArn() );
       out.println( "Type" + ipn.getType() );
       out.println( "UnsubscribeURL" + ipn.getUnsubscribeURL() );
       
       try { 
            out.println("Is IPN Valid:" + ipn.isNotificationValid());
       } catch(Exception e) {
           //
       }

       out.println("</body></html>");
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {
        doGet(request, response);
    }


}


    
