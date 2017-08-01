package test;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/*
*   String responseString = mockMvc.perform(
                get("/categories/getAllCategory")    //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)  //数据的格式
　　　　　　　　　　　　　　 .param("pcode","root")         //添加参数
        ).andExpect(status().isOk())    //返回的状态是200
                .andDo(print())         //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
        System.out.println("--------返回的json = " + responseString);
* */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/*.xml"})
@WebAppConfiguration
@Rollback
public class WxTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testzccx() throws Exception {
        mockMvc.perform(get("/wx/page/zccx/{id}", 1))
                .andExpect(model().attributeExists("policy"))
                .andExpect(view().name("wx/zccx"))
                // .andExpect(forwardedUrl("/WEB-INF/pages/wx/zccx.jsp"))//验证视图渲染时forward到的jsp
                .andExpect(status().isOk())//验证状态码
                .andDo(print()) //输出MvcResult到控制台
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void test() throws Exception {
        mockMvc.perform(get("/wx/test/{id}", 6))
                .andExpect(view().name("test"))
                .andDo(print());
    }

    @Test
    public void testmenu() throws Exception {
        mockMvc.perform(get("/wx/createMenuUI"))
                .andExpect(view().name("wx/createMenu"))
                .andDo(print());
    }

    @Test
    public void testMatch() {
        String a = "111";
        String b = "1";
        String c = "aaa";
        String d = "Atest";
        String matcher = "\\d{1}";
        System.out.println(a.getBytes().toString());
        String s = new String(a.getBytes());
        System.out.println(s);

        System.out.println(a.matches(matcher) + " " + b.matches(matcher) + " " + c.matches(matcher) + " " + d.matches(matcher));
    }

    @Test
    public void testLength() {
        System.out.println("o_YLgwO9W6lZx2epHy8HSzXxV2hA".length());
    }

    @Test
    public void testObjOUt() {
        File file = new File("c:/aa.data");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            User u = new User();
            u.setA("123");
            u.setB("456");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(u);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testVue() throws Exception {
        String contentAsString = mockMvc.perform(get("/vue/testPage").param("type", "qyxx").param("pageNo", "1"))
                .andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
        System.out.println("json数据===" + contentAsString);

    }
}
