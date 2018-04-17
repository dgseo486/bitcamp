package bitcamp.java106.pms.server;

import java.util.HashMap;

public class ServerRequest {
    protected String path;
    protected HashMap<String, String> paramMap = new HashMap<>();
    
    public ServerRequest(String requestLine) {
        String[] arr = requestLine.split("\\?");
        
        this.path = arr[0];
        if(arr.length > 1) {
            toParamMap(arr[1]);
        }
    }
    
    private void toParamMap(String queryString) {
        
        String[] entryArr = queryString.split("&");
        
        for(String entry : entryArr) {
            String[] keyValue = entry.split("=");
            this.paramMap.put(keyValue[0], keyValue[1]);
        }
    }
    
    public String getServerPath() {
        return this.path;
    }
    
    public String getParameter(String name) {
        return paramMap.get(name);
    }
}
