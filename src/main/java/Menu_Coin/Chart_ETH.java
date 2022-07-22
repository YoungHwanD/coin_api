package Menu_Coin;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.json.JSONArray;
import org.json.JSONObject;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Chart_ETH {
    public static void main(String[] args) throws Exception {


        double[] xData = new double[20]; // 메인메소드에 들어가야 쉬프트연산 가능 
        double[] yData = new double[20];

        for (int i = 0; i<20;i++){
            xData[i] = 0.0;
        }

        //초기값 10개의 데이터(각 1초)를 받아서 배열에 저장  *총 10초 소요
        final double[][] data = getAPIData(xData,yData,0); // 0으로 들어갔을땐 0~9 채우기 

        XYChart chart = QuickChart.getChart("Etherium Chart", "Timestamp", "Won", "ETH_Chart", null, data[1]); // x y데이터를 더블형으로 받음
        
        SwingWrapper<XYChart> sw = new SwingWrapper<XYChart>(chart);
        sw.displayChart();

        while (true) {
            System.out.println("update");

            //데이터 하나를 받아서 업데이트 2초간격
            double[][] APIData = getAPIData(xData,yData,1);

            chart.updateXYSeries("ETH_Chart", null, APIData[1], null); // null은 x Apidata는 y
            sw.repaintChart();
        }
    }
    private static double[][] getAPIData (double[] xData,double[] newData, int count) throws InterruptedException { // 쓰레드

    	//카운트가 0일 경우 배열 초기값 생성작업 실행
        if (count == 0){
            for (int i = 0; i < newData.length; i++) {
                newData[i] = updateData();
                Thread.sleep(50); 
            }
        }else {    // 카운트가 1일 경우 배열 업데이트 작업 실행
            Thread.sleep(1000); //1초
            for (int i =0 ; i< newData.length-1; i++){
                newData[i] = newData[i+1];       // 배열 왼쪽 Shift 연산 수행, 배열[0] 값 삭제후 배열[9]를 비움
            }
            newData[newData.length-1] = updateData();  //배열[9]에 업데이트한 데이터 저장
        }

        return new double[][]{xData, newData}; // 29번 줄에 리턴
    }

    private static double updateData() {
        double DTP = 0.0;
        String coin[] = {"KRW-BTC", "KRW-ETH", "KRW-XRP", "KRW-MATIC", "KRW-SOL", 
        		"KRW-BCH", "KRW-ADA", "KRW-AVAX", " KRW-AAVE", "KRW-TRX"};
        try {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://api.upbit.com/v1/candles/minutes/1?market=" + coin[1] + "&count=1")
                    .get()
                    .addHeader("Accept", "application/json")
                    .build();

            Response response = client.newCall(request).execute();

            String jsonData = response.body().string();


            JSONArray jsonArr = new JSONArray(jsonData);

            if (jsonArr.length() > 0) {
                for (int i = 0; i < jsonArr.length(); i++) {
                    JSONObject jsonObject = jsonArr.getJSONObject(i);
                    int TP = jsonObject.getInt("trade_price");
                    DTP = jsonObject.getDouble("trade_price");
                    System.out.println(TP);    //콘솔에 가져온 opening_price 값 출력

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return DTP; 
    }
}

