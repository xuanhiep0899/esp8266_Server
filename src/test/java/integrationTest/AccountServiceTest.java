package integrationTest;

import com.EspServer.Esp.entities.Account;
import com.EspServer.Esp.entities.RoleName;
import com.EspServer.Esp.repository.AccountRepository;
import com.EspServer.Esp.service.AccountService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
public class AccountServiceTest {


    @MockBean
    AccountRepository accountRepository;


    @Mock
    private AccountService accountService;


    @Before
    public void setUp() {
        Mockito.when(accountRepository.findAll())
                .thenReturn(IntStream.range(0, 10)
                        .mapToObj(account -> new Account("long" + account,
                                "password" + account,
                                RoleName.ROLE_ADMIN,
                                LocalDateTime.now(),
                                LocalDateTime.now())).collect(Collectors.toList()));
    }

    @Test
    public void testCount() {
        List<Account> accounts = IntStream.range(0, 10)
                .mapToObj(account -> new Account("long" + account,
                        "password" + account,
                        RoleName.ROLE_ADMIN,
                        LocalDateTime.now(),
                        LocalDateTime.now())).collect(Collectors.toList());
        Mockito.when(accountService.count()).thenReturn(accounts.size());
        Assert.assertEquals(10, accounts.size());
    }
}
