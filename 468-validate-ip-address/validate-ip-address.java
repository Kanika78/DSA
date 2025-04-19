class Solution {
    public String validIPAddress(String queryIP) {
        if(queryIP.length()==0) return "Neither";
        
        if(queryIP.indexOf(".")>=0) return validateIPV4(queryIP);
        
        if(queryIP.indexOf(":")>=0) return validateIPV6(queryIP);

        else{
            return "Neither";
        }
    }

    public String validateIPV4(String ip){
        if(ip.charAt(0) == '.' || ip.charAt(ip.length()-1) == '.'){
            return "Neither";
        }
        String[] s = ip.split("\\.");

        if(s.length != 4){
            return "Neither";
        }

        for(String str : s){
            if(str.length() == 0 || str.length()>3 || (str.charAt(0)=='0' && str.length()>1)){
                return "Neither";
            }
            for(char ch : str.toCharArray()){
                if(ch < '0' || ch > '9'){
                    return "Neither";
                }
            }
            int num = Integer.parseInt(str);
            if(num < 0 || num > 255){
                return "Neither";
            }
        }
        return "IPv4";

    }
    public String validateIPV6(String ip){
        if(ip.charAt(0) == ':' || ip.charAt(ip.length()-1) == ':'){
            return "Neither";
        }
        String[] s = ip.split(":");

        if(s.length != 8){
            return "Neither";
        }

        for(String str : s){
            if(str.length() == 0 || str.length()>4){
                return "Neither";
            }
            for(char ch : str.toLowerCase().toCharArray()){
                if((ch < '0' || ch > '9' )&& (ch!='a' && ch!='b' && ch!='c' && ch!='d' && ch!='e' && ch!='f')){
                    return "Neither";
                }
            }
        }
        return "IPv6";

    }
    
}