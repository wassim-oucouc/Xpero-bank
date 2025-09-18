import model.Session;
import model.User;
import repository.AccountRepository;
import repository.SessionRepository;
import repository.TransactionRepository;
import repository.UserRepository;
import repository.implement.InMemoryAccountRepository;
import repository.implement.InMemorySessionRepository;
import repository.implement.InMemoryTransactionRepository;
import repository.implement.InMemoryUserRepository;
import service.*;
import ui.AppConsole;

public class Main {

    public static void main(String[] args){

        UserRepository userRepository = new InMemoryUserRepository();
        AuthService authService = new AuthService(userRepository);
        SessionRepository sessionRepository = new InMemorySessionRepository();
        AccountRepository accountRepository = new InMemoryAccountRepository();
        AccountService accountService = new AccountService(accountRepository);
        SessionService sessionService = new SessionService(sessionRepository);
        UserService userService = new UserService(userRepository);
        TransactionRepository transactionRepository = new InMemoryTransactionRepository();
        TransactionService transactionService = new TransactionService(transactionRepository);
       AppConsole app = new AppConsole(authService,userRepository,sessionService,accountService,userService,transactionService);
       app.run();


    }
}