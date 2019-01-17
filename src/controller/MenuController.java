package controller;


import IO.IO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jfoenix.controls.*;
import datastructure.Constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import datastructure.MyList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import methods.*;

/**
 * Created by LSK.Reno on 2018/7/26.
 */


public class MenuController {

    @FXML
    private JFXButton administerButton;

    @FXML
    private JFXButton exitButton;

    @FXML
    private Tab scenicSpotsMapTAB;

    @FXML
    private Label scenicSpotsMapLabel;

    @FXML
    private Tab guideRouteMapTAB;

    @FXML
    private AnchorPane guideRoutePane;

    @FXML
    private JFXButton guideRouteMapButton;

    @FXML
    private JFXTextField startNameGuideRouteText;

    @FXML
    private JFXTextField endNameGuideRouteText;

    @FXML
    private JFXComboBox<String> guideRouteComboBox;

    @FXML
    private Label guideRouteMapLabel;

    @FXML
    private Label guideRouteDisLabel;

    @FXML
    private Tab shortestPathTAB;

    @FXML
    private AnchorPane shortestPathPane;

    @FXML
    private JFXButton shortestPathButton;

    @FXML
    private JFXTextField startNameText;

    @FXML
    private JFXTextField endNameText;

    @FXML
    private JFXComboBox<String> shortestPathComboBox;

    @FXML
    private Label shortestPathMapLabel;

    @FXML
    private Label shortestDisLabel;

    @FXML
    private JFXButton parkingButton;

    @FXML
    private Tab searchAndSortTAB;

    @FXML
    private AnchorPane searchAndSortPane;

    @FXML
    private JFXTextField searchText;

    @FXML
    private JFXButton KMPSearchButton;

    @FXML
    private JFXButton BoyerMooreSearchButton;

    @FXML
    private JFXButton roadNumSortButton;

    @FXML
    private JFXButton popularitySortButton;

    @FXML
    private JFXButton backToMenuButton;

    @FXML
    private JFXComboBox<String> sortAlgorithmComboBox;

    @FXML
    private JFXTextArea announcement1;

    @FXML
    private JFXTextArea announcement2;

    @FXML
    private JFXTextArea announcement3;

    @FXML
    private JFXTextArea announcement4;

    @FXML
    private JFXTextArea announcement5;

    @FXML
    private Label announcementTime1;

    @FXML
    private Label announcementTime2;

    @FXML
    private Label announcementTime3;

    @FXML
    private Label announcementTime4;

    @FXML
    private Label announcementTime5;

    @FXML
    private Label sortLabel1;

    @FXML
    private Label sortLabel4;

    @FXML
    private Label sortLabel7;

    @FXML
    private Label sortLabel10;

    @FXML
    private Label sortLabel3;

    @FXML
    private Label sortLabel2;

    @FXML
    private Label sortLabel9;

    @FXML
    private Label sortLabel6;

    @FXML
    private Label sortLabel5;

    @FXML
    private Label sortLabel12;

    @FXML
    private Label sortLabel11;

    @FXML
    private Label sortLabel8;

    @FXML
    private Label sortLabel13;

    @FXML
    private Label sortLabel14;

    @FXML
    private Label sortLabel15;

    @FXML
    private Label sortTypeLabel;

    @FXML
    private JFXButton searchButton1;

    @FXML
    private JFXButton searchButton11;

    @FXML
    private JFXButton searchButton6;

    @FXML
    private JFXButton searchButton7;

    @FXML
    private JFXButton searchButton5;

    @FXML
    private JFXButton searchButton4;

    @FXML
    private JFXButton searchButton3;

    @FXML
    private JFXButton searchButton2;

    @FXML
    private JFXButton searchButton10;

    @FXML
    private JFXButton searchButton9;

    @FXML
    private JFXButton searchButton13;

    @FXML
    private JFXButton searchButton12;

    @FXML
    private JFXButton searchButton8;

    @FXML
    private JFXButton searchButton15;

    @FXML
    private JFXButton searchButton14;

    @FXML
    private AnchorPane scenicInfoPane;

    @FXML
    private Label scenicNameLabel;

    @FXML
    private Label popularityLabel;

    @FXML
    private Label hasRestLabel;

    @FXML
    private Label hasToiletLabel;

    @FXML
    private Label desLabel;

    @FXML
    private Label surroundLabel;

    @FXML
    private JFXButton backToSearchAndSortButton;

    @FXML
    private JFXTextField addCarNumberText;

    @FXML
    private JFXButton carInButton;

    @FXML
    private Label carParkingInfoLabel;

    @FXML
    private JFXTextField deleteCarNumberText;

    @FXML
    private JFXButton carOutButton;

    @FXML
    private Label carOutInfoLabel;

    public MyList<String> scenicInfo = new MyList<>();

    public int searchAndSortCount = 0;

    public int carParkingControl = 0;


    @FXML
    public void initialize() {
        CreatePark createPark = new CreatePark();
        createPark.create();

        OutputScenicSpotsMap();
        JFXComboBox sortAlgorithmBox = (JFXComboBox) searchAndSortPane.lookup("#sortAlgorithmComboBox");
        ObservableList<String> cardCategoryList = FXCollections.observableArrayList("冒泡排序", "选择排序",
                "插入排序", "希尔排序","归并排序", "快速排序","堆排序", "计数排序","桶排序", "基数排序");
        sortAlgorithmBox.setItems(cardCategoryList);

        JFXComboBox shortestPathBox = (JFXComboBox) shortestPathPane.lookup("#shortestPathComboBox");
        ObservableList<String> shortestPathList = FXCollections.observableArrayList("Dijkstra", "Floyd",
                "BellmanFord", "spfa");
        shortestPathBox.setItems(shortestPathList);

        JFXComboBox guideRouteBox = (JFXComboBox) guideRoutePane.lookup("#guideRouteComboBox");
        ObservableList<String> guideRouteList = FXCollections.observableArrayList("Hamilton", "DFS",
                "Euler", "bdfs plus");
        guideRouteBox.setItems(guideRouteList);

        // 初始化加载公告
        ShowAnnouncement showAnnouncement = new ShowAnnouncement();
        String announcement= showAnnouncement.ShowAnnouncement();
        JSONObject jsonGraph = JSON.parseObject(announcement);
        JSONArray announcementList = jsonGraph.getJSONArray("list");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (int i=0;i<announcementList.size();i++){
            switch (i){
                case 0:
                    announcement1.setText(announcementList.getJSONObject(i).getString("message"));
                    announcementTime1.setText(announcementList.getJSONObject(i).getString("time"));
                    break;
                case 1:
                    announcement2.setText(announcementList.getJSONObject(i).getString("message"));
                    announcementTime2.setText(announcementList.getJSONObject(i).getString("time"));
                    break;
                case 2:
                    announcement3.setText(announcementList.getJSONObject(i).getString("message"));
                    announcementTime3.setText(announcementList.getJSONObject(i).getString("time"));
                    break;
                case 3:
                    announcement4.setText(announcementList.getJSONObject(i).getString("message"));
                    announcementTime4.setText(announcementList.getJSONObject(i).getString("time"));
                    break;
                case 4:
                    announcement5.setText(announcementList.getJSONObject(i).getString("message"));
                    announcementTime5.setText(announcementList.getJSONObject(i).getString("time"));
                    break;
                default:
                    break;
            }

        }
    }

    /**输出景区景点分布图*/
     void OutputScenicSpotsMap() {
        CreateGraph createGraph = new CreateGraph();
        String displayGraph = createGraph.create();
        IO io = new IO();
        io.outputFile("D:\\TourSystem\\TourSystem\\ScenicGraph.json", displayGraph);
//        scenicSpotsMapLabel


    }

//    /**景点的查找与排序*/
//    @FXML
//    void searchAndSort(ActionEvent event) {
//        ScenicSearchAndSortController scenicSearchAndSortController= new ScenicSearchAndSortController();
//        Stage scenicSearchAndSortStage = scenicSearchAndSortController.setScenicSearchAndSortStage(Main.getStage());
//        scenicSearchAndSortStage.setTitle("景点自助查询与排序");
//        try {
//            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("ScenicSearchAndSort.fxml")));
//            scenicSearchAndSortStage.setScene(scene);
////            scene.getStylesheets().add(this.getClass().getResource("ScenicSearchAndSort.css").toExternalForm());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    /**输出导游线路图*/
    @FXML
    void OutputGuideRouteMap(ActionEvent event) {
        String startNameGuideRoute = startNameGuideRouteText.getText();
        String endNameGuideRoute = endNameGuideRouteText.getText();
        String selectGuideRoute = guideRouteComboBox.getValue();
        // {"tourList":[1,0,2,5,6,8,11,10,9,3,7,4,1],"pathLength":109}


        if (!selectGuideRoute.equals("DFS")){
            if (!startNameGuideRoute.equals(endNameGuideRoute)){

                guideRouteMapLabel.setText(selectGuideRoute+"算法只能用于计算回路, \n起点终点需相同,\n谢谢配合");
                guideRouteDisLabel.setText("-1");
            }
            else{
                TourMaps tourMaps = new TourMaps();
                String results = tourMaps.tourMaps(startNameGuideRoute, endNameGuideRoute, selectGuideRoute);
                JSONObject jsonObject = JSON.parseObject(results);
                String guideRouteMapLabelText = "";

                CreateGraph createGraph = new CreateGraph();
                String displayGraph = createGraph.create();
                JSONObject jsonGraph = JSON.parseObject(displayGraph);
                JSONArray nodes = jsonGraph.getJSONArray("nodes");
                JSONArray tourList = jsonObject.getJSONArray("tourList");
                for (int i=0;i<tourList.size();i++){
                    int index = (int) tourList.get(i);
                    guideRouteMapLabelText += nodes.getJSONObject(index).getString("name");

                    if (i!=(tourList.size()-1)) {
                        guideRouteMapLabelText += "--->";
                        if ((i%3)==2){
                            guideRouteMapLabelText += "\n";
                        }
                    }
                }
                guideRouteMapLabel.setText(guideRouteMapLabelText);
                guideRouteDisLabel.setText(String.valueOf(jsonObject.getInteger("pathLength")));
            }


        }else{
            TourMaps tourMaps = new TourMaps();
            String results = tourMaps.tourMaps(startNameGuideRoute, endNameGuideRoute, selectGuideRoute);
            JSONObject jsonObject = JSON.parseObject(results);
            String guideRouteMapLabelText = "";

            CreateGraph createGraph = new CreateGraph();
            String displayGraph = createGraph.create();
            JSONObject jsonGraph = JSON.parseObject(displayGraph);
            JSONArray nodes = jsonGraph.getJSONArray("nodes");
            JSONArray tourList = jsonObject.getJSONArray("tourList");
            for (int i=0;i<tourList.size();i++){
                int index = (int) tourList.get(i);
                guideRouteMapLabelText += nodes.getJSONObject(index).getString("name");

                if (i!=(tourList.size()-1)) {
                    guideRouteMapLabelText += "--->";
                    if ((i%3)==2){
                        guideRouteMapLabelText += "\n";
                    }
                }
            }
            guideRouteMapLabel.setText(guideRouteMapLabelText);
            guideRouteDisLabel.setText(String.valueOf(jsonObject.getInteger("pathLength")));
        }

    }

    /**两个景点间的最短路径和最短距离*/
    @FXML
    void shortestPath(ActionEvent event) {
        String startName = startNameText.getText();
        String endName = endNameText.getText();
        String selectShortest = shortestPathComboBox.getValue();
        Shortest shortest = new Shortest();
        String results = shortest.shortest(startName,endName ,selectShortest );
//        {"pathDis":22,"nodesIndex":[1,0,2,6]}
        JSONObject jsonObject = JSON.parseObject(results);
        shortestDisLabel.setText(String.valueOf(jsonObject.getInteger("pathDis")));
        if (jsonObject.getInteger("pathDis")==-1){
            shortestPathMapLabel.setText("对不起，无路可达");
        }
        else if(jsonObject.getInteger("pathDis")==32767){
            shortestPathMapLabel.setText("请低头看看您的脚下, \n您已经到达"+startName+"。");
        }
        else{
            String shortestPathMapLabelText = "";

            CreateGraph createGraph = new CreateGraph();
            String displayGraph = createGraph.create();

            JSONObject jsonGraph = JSON.parseObject(displayGraph);
            JSONArray nodes = jsonGraph.getJSONArray("nodes");
            JSONArray nodesIndex = jsonObject.getJSONArray("nodesIndex");
            for (int i=0;i<nodesIndex.size();i++){
                int index = (int) nodesIndex.get(i);
                shortestPathMapLabelText += nodes.getJSONObject(index).getString("name");
                if (i!=(nodesIndex.size()-1)) {
                    shortestPathMapLabelText += "--->";
                    if (isOdd(i)){
                        shortestPathMapLabelText += "\n";
                    }
                }
            }
            shortestPathMapLabel.setText(shortestPathMapLabelText);
        }
    }

    /**停车场车辆进出记录信息*/
    @FXML
    void parking(ActionEvent event) {


    }

    /**车辆进入*/
    @FXML
    void carIn(ActionEvent event){
        AddPark addPark = new AddPark();
        String results = addPark.addPark(addCarNumberText.getText());
//        System.out.println(results);
//        {"exist":false,"parking":[{"arrive_time":1547628170295,"number":"lsk1"}],"tempParking":[],"shortcut":[]}
//        {"exist":false,"parking":[{"arrive_time":1547628174109,"number":"lsk2"},{"arrive_time":1547628170295,"number":"lsk1"}],"tempParking":[],"shortcut":[]}
//        {"exist":false,"parking":[{"arrive_time":1547628179752,"number":"lsk3"},{"arrive_time":1547628174109,"number":"lsk2"},{"arrive_time":1547628170295,"number":"lsk1"}],"tempParking":[],"shortcut":[]}
//        {"exist":false,"parking":[{"arrive_time":1547628179752,"number":"lsk3"},{"arrive_time":1547628174109,"number":"lsk2"},{"arrive_time":1547628170295,"number":"lsk1"}],"tempParking":[],"shortcut":[{"number":"lsk4"}]}
//        请输入正确的车牌号码
//        {"exist":true}
        if (results.equals("请输入正确的车牌号码")){
            carParkingInfoLabel.setText(results);
        }
        else{
            JSONObject carParkingInfo = JSON.parseObject(results);
            boolean exist = carParkingInfo.getBoolean("exist");
            JSONArray parking = carParkingInfo.getJSONArray("parking");
            JSONArray shortcut = carParkingInfo.getJSONArray("shortcut");

            if (!exist && carParkingControl<Constants.PARKING_SIZE){
                carParkingInfoLabel.setText("车牌号码为："
                        + parking.getJSONObject(0).getString("number")
                        + "的车辆，于"
                        + parking.getJSONObject(0).getString("arrive_time")
                        + "停入停车场");
                carParkingControl++;
            }
            else if (!exist && parking.size()==Constants.PARKING_SIZE){
                carParkingInfoLabel.setText("车牌号码为："
                        + shortcut.getJSONObject(shortcut.size()-1).getString("number")
                        + "的车辆, 由于停车场车位不足, 在便道等候车位");
            }
            else if (exist){
                carParkingInfoLabel.setText("该车辆已停入停车场或在便道等候区, 无需再次泊车");
            }
        }
    }

    /**车辆退出*/
    @FXML
    void carOut(ActionEvent event){
        DeletePark deletePark= new DeletePark();
        String results = deletePark.deletePark(deleteCarNumberText.getText());
        System.out.println(results);
//        {"exist":true,"length":4,
//          "parking":[
//                  [{"arrive_time":1547636690533,"number":"lsk2"},{"arrive_time":1547636687564,"number":"lsk1"}]
//                 ,[{"arrive_time":1547636687564,"number":"lsk1"}]
//                 ,[]
//                 ,[{"arrive_time":1547636690533,"number":"lsk2"}]  ]
//      ,"tempParking":[
//                  []
//                  ,[{"arrive_time":1547636690533,"number":"lsk2"}]
//                  ,[{"arrive_time":1547636690533,"number":"lsk2"}]
//                  ,[]]
//      ,"shortcut":[[],[],[],[]],"parkTime":0.12106667,"cost":6.0}

//        {"exist":true,"length":2,
//                "parking":[
//                        [{"arrive_time":1547638868865,"number":"lsk1"}]
//            ,[]]
//            ,"tempParking":[[],[]],"shortcut":[[],[]],"parkTime":0.06955,"cost":3.0}


//        {"exist":true,"length":5,
//                "parking":[
//                        [{"arrive_time":1547639087315,"number":"lsk3"}
//                        ,{"arrive_time":1547639083767,"number":"lsk2"}
//                        ,{"arrive_time":1547639080214,"number":"lsk1"}]
//            ,[{"arrive_time":1547639083767,"number":"lsk2"},{"arrive_time":1547639080214,"number":"lsk1"}]
//            ,[{"arrive_time":1547639080214,"number":"lsk1"}]
//            ,[{"arrive_time":1547639087315,"number":"lsk3"},{"arrive_time":1547639080214,"number":"lsk1"}]
//            ,[{"arrive_time":1547639105410,"number":"lsk4"},{"arrive_time":1547639087315,"number":"lsk3"},{"arrive_time":1547639080214,"number":"lsk1"}]]
//            ,"tempParking":[[],[{"arrive_time":1547639087315,"number":"lsk3"}],[{"arrive_time":1547639087315,"number":"lsk3"}],[],[]]
//            ,"shortcut":[[{"number":"lsk4"},{"number":"lsk5"}],[{"number":"lsk4"},{"number":"lsk5"}],[{"number":"lsk4"},{"number":"lsk5"}],[{"number":"lsk4"},{"number":"lsk5"}],[{"number":"lsk5"}]]
//            ,"parkTime":0.36071667,"cost":18.0}

        JSONObject carOutInfo = JSON.parseObject(results);
        String exist = carOutInfo.getString("exist");

        if (exist==null){
            carOutInfoLabel.setText("停车场此时没有车");
        }
        else if (exist.equals("false")){
            carOutInfoLabel.setText("没有在停车场发现此车, 请检查车牌号码或查看便道等待区车辆");
        }
        else if (exist.equals("true")){
            carOutInfoLabel.setText("车牌号为："
                    + deleteCarNumberText.getText()
                    + "的车辆已驶出, 停车总时长为："
                    + carOutInfo.getString("parkTime")
                    +", 停车总费用为："
                    + carOutInfo.getString("cost") );
            carParkingControl--;
        }



    }

    @FXML
    public void administer(ActionEvent actionEvent) {
        LoginController loginController = new LoginController();
        Stage LoginStage = loginController.setLoginStage(Main.getStage());
        LoginStage.setTitle("Administer Mode -- Log in");
        try {
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Login.fxml")));
            LoginStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**Search and Sort TAB*/
    @FXML
    void BoyerMooreSearch(ActionEvent event) {
        // 点击按钮后先将所有景点按钮全部隐藏
        JFXButton [] searchButtons = {searchButton1,searchButton2,searchButton3,searchButton4,searchButton5,searchButton6,
                searchButton7,searchButton8,searchButton9,searchButton10,searchButton11,searchButton12,searchButton13,
                searchButton14,searchButton15};
        for (JFXButton button:searchButtons) {
            button.setVisible(false);
        }

        String keyWord = searchText.getText();
        SearchNode searchNode = new SearchNode();
        String results = searchNode.searchNode(keyWord, "Boyer-Moore");
//      [1,11]
        results = results.replace("[","");
        results = results.replace("]","");
        String [] resultsList = results.split(",");

        CreateGraph createGraph = new CreateGraph();
        String displayGraph = createGraph.create();

        JSONObject jsonDisplayGraph = JSON.parseObject(displayGraph);
        JSONArray nodes = jsonDisplayGraph.getJSONArray("nodes");
        if (results.length()==0){
            System.out.println("");
        }
        else{
            for (String aResultsList : resultsList) {
                JSONObject scenic = nodes.getJSONObject(Integer.parseInt(aResultsList));
                searchButtons[Integer.parseInt(aResultsList)].setText(scenic.getString("name"));
                searchButtons[Integer.parseInt(aResultsList)].setVisible(true);
            }
        }
    }

    @FXML
    void KMPSearch(ActionEvent event) {
        // 点击按钮后先将所有景点按钮全部隐藏
        JFXButton [] searchButtons = {searchButton1,searchButton2,searchButton3,searchButton4,searchButton5,searchButton6,
                searchButton7,searchButton8,searchButton9,searchButton10,searchButton11,searchButton12,searchButton13,
                searchButton14,searchButton15};
        for (JFXButton button:searchButtons) {
            button.setVisible(false);
        }

        String keyWord = searchText.getText();
        SearchNode searchNode = new SearchNode();
        String results = searchNode.searchNode(keyWord, "KMP");
//      [1,2,3]
        results = results.replace("[","");
        results = results.replace("]","");
        String [] resultsList = results.split(",");

        CreateGraph createGraph = new CreateGraph();
        String displayGraph = createGraph.create();

        JSONObject jsonDisplayGraph = JSON.parseObject(displayGraph);
        JSONArray nodes = jsonDisplayGraph.getJSONArray("nodes");
        if (results.length()==0){
            System.out.println("");
        }
        else{
            for (String aResultsList : resultsList) {
                JSONObject scenic = nodes.getJSONObject(Integer.parseInt(aResultsList));
                searchButtons[Integer.parseInt(aResultsList)].setText(scenic.getString("name"));
                searchButtons[Integer.parseInt(aResultsList)].setVisible(true);
            }
        }

    }

    @FXML
    void searchedScenic1(ActionEvent event) {
        scenicInfoPane.setVisible(true);
        displayScenicInfo(searchButton1);
    }

    public void displayScenicInfo(JFXButton searchButton){
        //从按钮处获取当前按钮所代表的景点名称信息
        if (searchButton.isVisible()){
            scenicInfo.add(searchButton.getText());
        }

        CreateGraph createGraph = new CreateGraph();
        String displayGraph = createGraph.create();

        JSONObject jsonDisplayGraph = JSON.parseObject(displayGraph);
        JSONArray nodes = jsonDisplayGraph.getJSONArray("nodes");
        for (int i = 0; i < nodes.size(); i++) {
            JSONObject node = nodes.getJSONObject(i);
            String name = node.getString("name");
            if (name.equals(scenicInfo.getData(6*searchAndSortCount))){
                String pop = node.getString("pop");
                String hasRest = node.getString("hasRest");
                String hasToilet = node.getString("hasToilet");
                String edges = node.getString("edges");
                String des = node.getString("des");
                scenicInfo.add(pop);
                scenicInfo.add(hasRest);
                scenicInfo.add(hasToilet);
                scenicInfo.add(edges);
                scenicInfo.add(des);
            }
        }
//        0 1 2 3 4  5
//        6 7 8 9 10 11
        Label [] infoLabels = {scenicNameLabel,popularityLabel, hasRestLabel,
                hasToiletLabel, surroundLabel,desLabel};
        for (int i = 6*searchAndSortCount; i <(6*searchAndSortCount+6) ; i++) {
//            System.out.println(scenicInfo.getData(i));
            infoLabels[i%6].setText(scenicInfo.getData(i));
        }
        searchAndSortCount++;
    }

    @FXML
    void notVisible(ActionEvent event) {
        scenicInfoPane.setVisible(false);
    }


    @FXML
    void popularitySort(ActionEvent event) {
        String sortAlgo = sortAlgorithmComboBox.getValue();
        sortTypeLabel.setText("以"+sortAlgo+"按欢迎度进行排序：");

        SortArc sortArc = new SortArc();
        String results = sortArc.sortArc("按欢迎度", sortAlgo);
//        System.out.println(results);
//        [{"name":"朝日峰","value":120},{"name":"碧水潭","value":100},{"name":"一线天","value":90},
//          {"name":"仙武湖","value":90},{"name":"九曲桥","value":85},{"name":"花卉园","value":82},
//          {"name":"观云台","value":80},{"name":"北门","value":80},{"name":"仙云石","value":75},
//          {"name":"飞流瀑","value":75},{"name":"红叶亭","value":70},{"name":"狮子山","value":70}]
        JSONArray jsonArray= JSON.parseArray(results);
        for (int i = 0; i < jsonArray.size(); i++) {
            switch (i){
                case 0:
                    sortLabel1.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 1:
                    sortLabel2.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 2:
                    sortLabel3.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 3:
                    sortLabel4.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 4:
                    sortLabel5.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 5:
                    sortLabel6.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 6:
                    sortLabel7.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 7:
                    sortLabel8.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 8:
                    sortLabel9.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 9:
                    sortLabel10.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 10:
                    sortLabel11.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 11:
                    sortLabel12.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 12:
                    sortLabel13.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 13:
                    sortLabel14.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 14:
                    sortLabel15.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                default:
                    break;
            }
        }
    }

    @FXML
    void roadNumSort(ActionEvent event) {
        String sortAlgo = sortAlgorithmComboBox.getValue();

        sortTypeLabel.setText("以"+sortAlgo+"按景点路口数进行排序：");

        SortArc sortArc = new SortArc();
        String results = sortArc.sortArc("按景点路口数", sortAlgo);
//        System.out.println(results);
//        [{"name":"狮子山","value":4},{"name":"仙云石","value":4},{"name":"一线天","value":4},
//         {"name":"仙武湖","value":4},{"name":"九曲桥","value":4},{"name":"观云台","value":4},
//         {"name":"碧水潭","value":4},{"name":"红叶亭","value":4},{"name":"朝日峰","value":4},
//         {"name":"花卉园","value":2},{"name":"北门","value":2},{"name":"飞流瀑","value":2}]
        JSONArray jsonArray= JSON.parseArray(results);
        for (int i = 0; i < jsonArray.size(); i++) {
            switch (i){
                case 0:
                    sortLabel1.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 1:
                    sortLabel2.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 2:
                    sortLabel3.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 3:
                    sortLabel4.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 4:
                    sortLabel5.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 5:
                    sortLabel6.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 6:
                    sortLabel7.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 7:
                    sortLabel8.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 8:
                    sortLabel9.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 9:
                    sortLabel10.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 10:
                    sortLabel11.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 11:
                    sortLabel12.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 12:
                    sortLabel13.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 13:
                    sortLabel14.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                case 14:
                    sortLabel15.setText(jsonArray.getJSONObject(i).getString("name")
                            + jsonArray.getJSONObject(i).getString("value"));
                    break;
                default:
                    break;
            }
        }

    }
    /**
     * 返回主菜单
     * */
    @FXML
    void backToMenu(ActionEvent event) {
        Stage primaryStage = Main.getStage();
        try {
            primaryStage.setTitle("Welcome To Tour System -- Menu");
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("Menu.fxml")));
            primaryStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**判断奇偶*/
    public boolean isOdd(int number){
        if(number%2 == 1){   //是奇数
            return true;
        }
        return false;
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(1);

    }

    @FXML
    void searchedScenic2(ActionEvent event) {
        scenicInfoPane.setVisible(true);
        displayScenicInfo(searchButton2);
    }
    @FXML
    void searchedScenic3(ActionEvent event) {
        scenicInfoPane.setVisible(true);
        displayScenicInfo(searchButton3);
    }
    @FXML
    void searchedScenic4(ActionEvent event) {
        scenicInfoPane.setVisible(true);
        displayScenicInfo(searchButton4);
    }
    @FXML
    void searchedScenic5(ActionEvent event) {
        scenicInfoPane.setVisible(true);
        displayScenicInfo(searchButton5);
    }
    @FXML
    void searchedScenic6(ActionEvent event) {
        scenicInfoPane.setVisible(true);
        displayScenicInfo(searchButton6);
    }
    @FXML
    void searchedScenic7(ActionEvent event) {
        scenicInfoPane.setVisible(true);
        displayScenicInfo(searchButton7);
    }
    @FXML
    void searchedScenic8(ActionEvent event) {
        scenicInfoPane.setVisible(true);
        displayScenicInfo(searchButton8);
    }
    @FXML
    void searchedScenic9(ActionEvent event) {
        scenicInfoPane.setVisible(true);
        displayScenicInfo(searchButton9);
    }
    @FXML
    void searchedScenic10(ActionEvent event) {
        scenicInfoPane.setVisible(true);
        displayScenicInfo(searchButton10);
    }
    @FXML
    void searchedScenic11(ActionEvent event) {
        scenicInfoPane.setVisible(true);
        displayScenicInfo(searchButton11);
    }
    @FXML
    void searchedScenic12(ActionEvent event) {
        scenicInfoPane.setVisible(true);
        displayScenicInfo(searchButton12);
    }
    @FXML
    void searchedScenic13(ActionEvent event) {
        scenicInfoPane.setVisible(true);
        displayScenicInfo(searchButton13);
    }
    @FXML
    void searchedScenic14(ActionEvent event) {
        scenicInfoPane.setVisible(true);
        displayScenicInfo(searchButton14);
    }
    @FXML
    void searchedScenic15(ActionEvent event) {
        scenicInfoPane.setVisible(true);
        displayScenicInfo(searchButton15);
    }



}































