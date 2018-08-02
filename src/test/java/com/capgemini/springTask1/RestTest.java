package com.capgemini.springTask1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.springTask1.player.PlayerDTO;
import com.capgemini.springTask1.player.PlayerService;
import com.capgemini.springTask1.player.PlayerServiceController;
import org.mockito.junit.MockitoJUnitRunner;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.when;

import org.assertj.core.util.Lists;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RestTest {
	private MockMvc mockMvc;
	
	@Mock
    private PlayerService playerService;
	
	

    @InjectMocks
    private PlayerServiceController playerController;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(playerController).build();
    }

    @Test
    public void testGetProfile() throws Exception {
        // given
    
        // when
        ResultActions resultActions = mockMvc.perform(get("/getuserprofile"));
        // then
        resultActions.andExpect(status().isOk());
          
    }
    
    @Test
    public void testChangeProfile() throws Exception {
        // given
    	
        // when
        ResultActions resultActions = mockMvc.perform(post("/changeprofile"));
        // then
        resultActions.andExpect(status().isOk());
          
    }
    
    @Test
    public void testFindUser() throws Exception {
        // given
    	
        // when
        ResultActions resultActions = mockMvc.perform(post("/finduser"));
        // then
        resultActions.andExpect(status().isOk());
          
    }
}



//
//@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
//public class BooksControllerTest {
//
//    private MockMvc mockMvc;
//
//    @Mock
//    private BookService bookService;
//
//    @InjectMocks
//    private BooksController booksController;
//
//    @Before
//    public void setup() {
//        mockMvc = MockMvcBuilders.standaloneSetup(booksController).build();
//    }
//
//    @Test
//    public void testBooksPage() throws Exception {
//        // given
//        when(bookService.findAllBooks()).thenReturn(Lists.newArrayList());
//        // when
//        ResultActions resultActions = mockMvc.perform(get("/books"));
//        // then
//        resultActions.andExpect(status().isOk())
//                .andExpect(view().name("booksList"));
//    }
//
//    @Test
//    public void testAddBooksPage() throws Exception {
//        // given when
//        ResultActions resultActions = mockMvc.perform(get("/books/add"));
//        // then
//        resultActions.andExpect(status().isOk())
//                .andExpect(view().name("addBook")).andExpect(model()
//                .attributeExists("newBook"));
//    }
//
//    @Test
//    public void testGreetingPage() throws Exception {
//        // given
//
//        // when
//        ResultActions resultActions = mockMvc.perform(post("/greeting"));
//        // then
//        resultActions.andExpect(status().isOk())
//                .andExpect(view().name("welcome"))
//                .andExpect(model().attribute(ModelConstants.MESSAGE, "Success!"));
//    }
//
//    @Test
//    public void testShowBookWithId() throws Exception {
//        // given
//
//        // when
//        ResultActions resultActions = mockMvc.perform(get("/books/id}").param("id", "3"));
//        // then
//        resultActions.andExpect(status().isOk())
//                .andExpect(view().name("book"));
//
//    }
//
//    @Test
//    public void testSearchPage() throws Exception {
//        // given
//
//        // when
//        ResultActions resultActions = mockMvc.perform(get("/books/search"));
//        // then
//        resultActions.andExpect(status().isOk())
//                .andExpect(view().name("searchPage"))
//                .andExpect(model()
//                        .attributeExists("newBook"));
//    }
//
//    @Test
//    public void testSearchingPage() throws Exception {
//        // given
//
//        // when
//        ResultActions resultActions = mockMvc.perform(post("/searching"));
//        // then
//        resultActions.andExpect(status().isOk())
//                .andExpect(view().name("booksList"))
//                .andExpect(model()
//                        .attributeExists("bookList", "info"));
//    }
//
//    @Test
//   @WithMockUser(username = "admin", roles = "ADMIN")
//    public void deleteWithAdmin() throws Exception {
//        // given
//
//        // when
//        ResultActions resultActions = mockMvc.perform(get("/delete/id").param("id","2"));
//        // then
//        resultActions.andExpect(status().isOk())
//                .andExpect(model().attribute(ModelConstants.MESSAGE, "Success!"))
//        .andExpect(view().name("welcome"));
//
//    }
//
//    //This should not work but works
//    @Test
//    @WithMockUser(username = "user")
//    public void deleteWithUser() throws Exception {
//        // given
//
//        // when
//        ResultActions resultActions = mockMvc.perform(get("/delete/id").param("id","2"));
//        // then
//        resultActions.andExpect(status().isOk())
//                .andExpect(model().attribute(ModelConstants.MESSAGE, "Success!"))
//                .andExpect(view().name("welcome"));
//
//    }
//}