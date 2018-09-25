/**
 * Created by Administrator on 2017/6/7.
 */

import com.ddyunf.po.User;
import com.google.gson.Gson;
import com.sun.org.apache.xerces.internal.impl.PropertyManager;
import javafx.scene.NodeBuilder;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.mapper.ObjectMapper;
import org.elasticsearch.index.mapper.RootObjectMapper;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/application.xml")
public class SpringTest {
//@Resource(name = "UserService1")
//com.ddyunf.dd.service.UserService userService1;


  @Test
   public void Test01() {
//        User user = new User();
//        user.setName("aa");
//        User user1 = userService1.findUserByAllId(1);
//        System.out.println(user1);
      StandardPasswordEncoder standardPasswordEncoder = new StandardPasswordEncoder();
      String uid ="2132323232";
      String key = "_derer2";
      System.out.println(standardPasswordEncoder.encode(uid+key));
      System.out.println(standardPasswordEncoder.encode(uid+key));
      System.out.println(standardPasswordEncoder.encode(uid+key));
      System.out.println(standardPasswordEncoder.encode(uid+key));
      System.out.println(standardPasswordEncoder.encode(uid+key));

//        User user2 = userService1.findUserById(1);
//        System.out.println(user2);
//        User user2 =    userService2.findUserByAllId(1);
//        System.out.println(user2);
    }

    //    public static void main(String[] args) {
//        String ddd = "17726295662," +
//                "18323438143," +
//                "15922508667," +
//                "15683159447," +
//                "18716351158," +
//                "13036366106," +
//                "17783023546," +
//                "15730493834," +
//                "18201751046," +
//                "15723403499," +
//                "15730367053," +
//                "17783810766," +
//                "18725942523," +
//                "13251317628," +
//                "15111811956," +
//                "13594327454," +
//                "15808011663," +
//                "18696557853," +
//                "15823422810," +
//                "18323033592," +
//                "13618284852," +
//                "17725002392," +
//                "15736115818," +
//                "15923125103," +
//                "15802345537," +
//                "18166315599," +
//                "15730159746," +
//                "18223467130," +
//                "15023025220," +
//                "18875167450";
//
//
//        int num = 25786685;
//        String[] phones = ddd.split(",");
//
//        for (String ph : phones) {
//
//            System.out.println("UPDATE b_user SET extNum='" + num + "' WHERE phoneNo='" + ph + "';");
//            num = num + 1;
//        }
//
//    }

    private static Client getElkClient() throws Exception {
        TransportAddress address = new InetSocketTransportAddress(
                InetAddress.getByName("139.199.119.214"), 9300);

//.put("cluster.name", "ddyunf-application")
        Settings settings = Settings.builder().put("cluster.name", "ddyunf-application")
                .put("client.transport.sniff", true).put("client.transport.ignore_cluster_name", true)
                .build();


//        //设置集群名称
//        Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
//        //创建client
//        TransportClient client = new PreBuiltTransportClient(settings)
//                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
////        //搜索数据
////        GetResponse response = client.prepareGet("blog", "article", "1").execute().actionGet();
////        //输出结果
////        System.out.println(response.getSourceAsString());


        return new PreBuiltTransportClient(settings).addTransportAddress(address);
    }
//    private TransportClient initElasticSearchClient() throws IOException {
//        Settings settings = Settings.builder().put("cluster.name", "ddyunf-application").build();
//        TransportClient transportClient = TransportClient..settings(settings).build();
//        return transportClient.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.1.25"), 9300));
//    }、、

    public static void query1() {
        RestClient restClient = RestClient.builder(
                new HttpHost("139.199.119.214", 9200, "http")).build();
        String ddd = "{\n" +
                "    \"query\": {\n" +
                "        \"match\" : {\n" +
                "            \"name\" : \"刘0\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        HttpEntity entity = new NStringEntity(ddd, ContentType.APPLICATION_JSON);


        try {
            Response indexResponse = restClient.performRequest(
                    "GET",
                    "userindex/user/_search",
                    Collections.<String, String>emptyMap(),
                    entity);

            System.out.println(indexResponse);
            System.out.print(IOUtils.toString(indexResponse.getEntity().getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteById() {
        RestClient restClient = RestClient.builder(
                new HttpHost("139.199.119.214", 9200, "http")).build();
        try {
            Response indexResponse = restClient.performRequest(
                    "DELETE",
                    "userindex/user/101",
                    Collections.<String, String>emptyMap());

            System.out.println(indexResponse);
            System.out.print(IOUtils.toString(indexResponse.getEntity().getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createIndex() {
        try {
            //  Client client = getElkClient();
//            NodeBuilder builder = NodeBuilder.nodeBuilder();
//            String clusterName = PropertyManager.getContextProperty("cluster.name");
//            builder.clusterName(clusterName);
//            Node node = builder.node();
//            Client client = node.client();
//            RestClientBuilder restClient = RestClient.builder(new HttpHost("http://139.199.119.214", 9200, "http"));
            RestClient restClient = RestClient.builder(
                    new HttpHost("139.199.119.214", 9200, "http")).build();


            List<User> persons = new ArrayList<User>();

            List<IndexRequest> requests = new ArrayList<IndexRequest>();
            int id = 100;
            for (int i = 0; i < 10; i++) {
                User person = new User();
                person.setAge(20 + i);
                person.setId(System.currentTimeMillis());

                person.setName("刘" + i);
                person.setSex("男");
                persons.add(person);

                id = id + 1;
                Gson gson = new Gson();
                String json = gson.toJson(person);


//index a document
                HttpEntity entity = new NStringEntity(json, ContentType.APPLICATION_JSON);


                Response indexResponse = restClient.performRequest(
                        "POST",
                        "userindex/user/" + id,
                        Collections.<String, String>emptyMap(),
                        entity);

//                requests.add(request);
            }

//            BulkRequestBuilder bulkRequest = client.prepareBulk();
//
//            for (IndexRequest request : requests) {
//                bulkRequest.add(request);
//            }
//
//            BulkResponse bulkResponse = bulkRequest.execute().actionGet();
//            if (bulkResponse.hasFailures()) {
//                System.out.println("批量创建索引错误！");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        //  deleteById();
        query1();
        // createIndex(); query1();

    }


}
