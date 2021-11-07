package task;
import java.net.*;
import java.util.HashMap;

public class WebAddressParser {
    private URL url;

    public WebAddressParser(String url) {
        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            this.url = null;
        }
    }

    public String getScheme() {
        if (url != null) {
            return url.getProtocol();
        }
        return "";
    }

    public String getLogin() {
        if (url != null) {
            String[] Authority = url.getAuthority().split("@");
            if (Authority.length >= 2) {
                String[] Username = Authority[0].split(":");
                if (Username.length >= 2) {
                    return Username[0];
                }
            }
        }
        return "";
    }

    public String getPassword() {
        if (url != null) {
            String[] Authority = url.getAuthority().split("@");
            if (Authority.length >= 2) {
                String[] Password = Authority[0].split(":");
                if (Password.length >= 2) {
                    return Password[1];
                }
            }
        }
        return "";
    }

    public boolean isValid() {
        if (url != null) {
            return true;
        }
        return false;
    }

    public String getHost() {
        if (url != null) {
            return url.getHost();
        }
        return "";
    }

    public String getPort() {
        if ((url != null) && (url.getPort() != -1)) {
            return Integer.toString(url.getPort());
        }
        return "";
    }

    public String getUrl() {
        if (url != null) {
            return url.getPath().replaceFirst("/", "");
        }
        return "";
    }

    public HashMap<String, String> getParameters() {
        if ((url!=null)&&(url.getQuery()!=null)) {
            String[] line = url.getQuery().split("&");
            HashMap<String, String> Par = new HashMap<>();
            String number[];
             for (int i=0;line.length>i;i++){
                 number=line[i].split("=");
                 Par.put(number[0],number[1]);
             }
             return Par;
    }
        return new HashMap<>();
}
 public String getFragment(){
    if ((url!=null)&&(url.getRef()!=null)) {
    return url.getRef();
    }
    return "";
 }
}