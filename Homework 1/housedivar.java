import java.util.Scanner;

public class housedivar {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.nextLine();
        if (n >= 1 && n <= 100){
            String[] names = new String[n];
            String[] types = new String[n];
            String[] statuses = new String[n];
            int[] prices = new int[n];
            int[] areas = new int[n];
            double[] latitudes = new double[n];
            double[] longitudes = new double[n];
            String[] descs = new String[n];
            String[] outputs = new String[n];
            int count_output = 0;
            int count_house = 0;

            for (int i=0; i<n; i++){
                String cmd = scn.nextLine();
                if (cmd.startsWith("add_house")){
                    String[] splits = cmd.split(" ");
                    String name = "";
                    String type = "";
                    String status = "";
                    int price = 0;
                    int area = 0;
                    double latitude = 0;
                    double longitude = 0;
                    String desc = "";
                    for (int j=0; j<splits.length; j++){
                        if (splits[j].startsWith("-name=")){
                            name = splits[j].substring(7,splits[j].length()-1);
                    
                        }

                        if (splits[j].startsWith("-type=")){
                            type = splits[j].substring(7,splits[j].length()-1);     
                        }
                        
                        if (splits[j].startsWith("-status=")){
                            status = splits[j].substring(9,splits[j].length()-1);     
                        }

                        if (splits[j].startsWith("-price=")){
                            price = Integer.parseInt(splits[j].substring(7,splits[j].length()));  
                        }

                        if (splits[j].startsWith("-area=")){
                            area = Integer.parseInt(splits[j].substring(6,splits[j].length()));  
                        }

                        if (splits[j].startsWith("-latitude=")){
                            latitude = Double.parseDouble(splits[j].substring(10,splits[j].length()));  
                        }

                        if (splits[j].startsWith("-longitude=")){
                            longitude = Double.parseDouble(splits[j].substring(11,splits[j].length()));  
                        }

                        if (splits[j].startsWith("-desc=")){
                            desc = splits[j].substring(7,splits[j].length()-1);     
                        }


                    }

                    int existing = 0;
                    for (int j=0; j<count_house; j++){
                        if (names[j].equals(name)){
                            existing = 1;
                        }
                    }

                    if (existing == 0){
                        names[count_house] = name;
                        types[count_house] = type;
                        statuses[count_house] = status;
                        prices[count_house]= price;
                        areas[count_house] = area;
                        latitudes[count_house]= latitude;
                        longitudes[count_house] = longitude;
                        descs[count_house] = desc;
                        outputs[count_output] = "house added successfully";
                        count_output += 1;
                        count_house += 1;
                    }
                    else{
                        outputs[count_output] = "invalid title";
                        count_output += 1;
                    }
                }

                if (cmd.startsWith("remove_house")){
                    String[] splits = cmd.split(" ");
                    String name = "";
                    for (int j=0; j<splits.length; j++){

                        if (splits[j].startsWith("-name=")){
                            name = splits[j].substring(7,splits[j].length()-1);
                        }
                    }

                    int flag = 0;
                    int remove_value = 0;
                    for (int j=0; j<count_house; j++){
                        if (names[j].equals(name)){
                            flag = 1;
                            remove_value = j;
                        }
                    }

                    if (flag == 1){
                        names[remove_value] = "";
                        types[remove_value] = "";
                        statuses[remove_value] = "";
                        prices[remove_value]= 0;
                        areas[remove_value] = 0;
                        latitudes[remove_value]= 999999999;
                        longitudes[remove_value] = 999999999;
                        descs[remove_value] = "";
                        outputs[count_output] = "house removed successfully";
                        count_output += 1;
                        count_house -= 1;
                    

                    }
                    else{
                        outputs[count_output] = "invalid title";
                        count_output += 1;
                    }
                    

                }

                if (cmd.startsWith("get_house")){
                    String splits[] = cmd.split(" ");
                    String type = "";
                    String status = "";
                    int min_price = 0;
                    int max_price = -1;
                    int min_area = 0;
                    int max_area = -1;
                    double latitude = 0;
                    double longitude = 0;
                    for (int j=0; j<splits.length; j++){
                        if (splits[j].startsWith("-type=")){
                            type = splits[j].substring(7,splits[j].length()-1); 

                        }
                        
                        if (splits[j].startsWith("-status=")){
                            status = splits[j].substring(9,splits[j].length()-1); 

                        }

                        if (splits[j].startsWith("-min_price=")){
                            min_price = Integer.parseInt(splits[j].substring(11,splits[j].length()));
                        }

                        if (splits[j].startsWith("-max_price=")){
                            max_price = Integer.parseInt(splits[j].substring(11,splits[j].length()));
                        }

                        if (splits[j].startsWith("-min_area=")){
                            min_area = Integer.parseInt(splits[j].substring(10,splits[j].length()));
                        }

                        if (splits[j].startsWith("-max_area=")){
                            max_area = Integer.parseInt(splits[j].substring(10,splits[j].length()));
                        }
                        
                        if (splits[j].startsWith("-latitude=")){
                            latitude = Double.parseDouble(splits[j].substring(10,splits[j].length()));  
                            
                        } 
                        
                        if (splits[j].startsWith("-longitude=")){
                            longitude = Double.parseDouble(splits[j].substring(11,splits[j].length()));  
                        }

                        





                    }

                    String[] get_results = new String[n];
                    double[] distances = new double[n];
                    int count_result = 0;

                    for (int j=0; j<count_house; j++){
                        int flag = 1;
                        if (!types[j].equals(type) || !statuses[j].equals(status)){
                        flag = 0;
                        }

                        if (prices[j]<min_price){
                            flag = 0;

                        }

                        if (prices[j] > max_price && max_price!=-1){
                            flag = 0;
                        }

                        if (areas[j] < min_area){
                            flag = 0;
                        }

                        if (areas[j] > max_area && max_area!=-1){
                            flag = 0;

                        }

                        if (flag == 1){
                            get_results[count_result] = names[j];
                            distances[count_result] = haversine(latitudes[j], longitudes[j], latitude, longitude);
                            count_result += 1;
                        }
                    }

                    for (int j=0; j<count_result-1; j++){
                        for (int k=0; k<count_result-1-j; k++){
                            if (distances[k] > distances[k + 1]){
                                double x = distances[k];
                                distances[k] = distances[k + 1];
                                distances[k + 1] = x;
                                String y = get_results[k];
                                get_results[k] = get_results[k + 1];
                                get_results[k + 1] = y;
                        }
                    }
                }

                if (count_result != 0){
                    String result = "";
                    for (int j=0; j<count_result; j++){
                        result = result + get_results[j] + " ";

                    }

                    outputs[count_output] = result;
                    count_output += 1;
                }

                else{
                    outputs[count_output] = "no house found!";
                    count_output += 1;
                }

                }
            }

            for (int i=0; i<count_output; i++){
            System.out.println(outputs[i]);
            }

        }

        
    }

    // I asked chatgpt to get info for haversine formula :
    public static double haversine(double latitude_1, double longitude_1, double latitude_2, double longitude_2){
        double r = 6378;
        double lat_1_radian = latitude_1 * (3.14/180);
        double lon_1_radian = longitude_1 * (3.14/180);
        double lat_2_radian = latitude_2 * (3.14/180);
        double lon_2_radian = longitude_2 * (3.14/180);

        double d_lat = lat_2_radian - lat_1_radian;
        double d_lon = lon_2_radian - lon_1_radian;
        double a = Math.pow(Math.sin(d_lat/2), 2) + (Math.cos(lat_1_radian)*Math.cos(lat_2_radian)*Math.pow(Math.sin(d_lon/2), 2));
        double c = 2*Math.atan(Math.pow(a, 0.5)/Math.pow(1-a, 0.5));
        double d = r*c;
        return d;
    }
                  
        



    
}
