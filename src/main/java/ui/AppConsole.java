package ui;

import model.Account;
import model.Session;
import model.Transaction;
import model.User;
import repository.UserRepository;
import service.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;


public class AppConsole {

    private AuthService authService;
    private UserRepository userRepository;
    private SessionService sessionService;
    private AccountService accountService;
    private UserService userService;
    private TransactionService transactionService;


    public AppConsole(AuthService authService, UserRepository userRepository, SessionService sessionService, AccountService accountService, UserService userService, TransactionService transactionService) {
        this.authService = authService;
        this.userRepository = userRepository;
        this.sessionService = sessionService;
        this.accountService = accountService;
        this.userService = userService;
        this.transactionService = transactionService;
    }


    public void run() {
        System.out.println("Welcome To XperoBank");
        System.out.println("-----------------------");
        int valueIntFirst = 0;
        do {
            System.out.println("==========================================");
            System.out.println("               MENU PRINCIPAL           ");
            System.out.println("==========================================");
            System.out.println(" 1 :  Register");
            System.out.println(" 2 :  Login");
            System.out.println(" 3 :  Exit");
            System.out.println("==========================================");
            System.out.print("➡ Veuillez choisir une option : ");
            Scanner inputValue = new Scanner(System.in);
            valueIntFirst = inputValue.nextInt();
            switch (valueIntFirst) {
                case 1:
                    this.Register();
                    break;
                case 2:
                    this.login();
                    break;
                case 3:
                    System.out.println("Good Bye!!");

            }
        } while (valueIntFirst != 3);
    }

    public void Register() {
        System.out.println("==========================================");
        System.out.println("         FORMULAIRE D’INSCRIPTION       ");
        System.out.println("==========================================");

        System.out.print("➡ Entrez votre Nom Complet : ");
        String inputName = new Scanner(System.in).nextLine();

        String inputEmail;
        do {
            System.out.print("➡ Entrez votre Email : ");
            inputEmail = new Scanner(System.in).nextLine();
            if (authService.CheckEmailExists(inputEmail) == false) {
                System.out.println("  Cet email existe déjà, veuillez en choisir un autre.");
            }
        } while (authService.CheckEmailExists(inputEmail) == false);

        String inputPassword;
        do {
            System.out.print("➡ Entrez votre Mot de Passe : ");
            inputPassword = new Scanner(System.in).nextLine();
            if (inputPassword.length() < 6) {
                System.out.println(" Mot de passe invalide (minimum 6 caractères).");
            }
        }while (inputPassword.length() < 6);

        System.out.print("➡ Entrez votre Adresse : ");
        String inputaddress = new Scanner(System.in).nextLine();

        User userCreation = new User(inputName, inputEmail, inputaddress, inputPassword);
        authService.RegisterUser(userCreation);

        System.out.println(" Inscription réussie ! Bienvenue " + inputName);
        System.out.println("==========================================");

    }

    public void login() {
        String login;
        String inputEmailLogin = "";
        String inputPasswordLogin = "";
        do {
            System.out.println("Entrer Votre Email");
            inputEmailLogin = new Scanner(System.in).nextLine();
            System.out.println("Entrer Votre Mot de Passe");
            inputPasswordLogin = new Scanner(System.in).nextLine();
            login = authService.LoginUser(inputEmailLogin, inputPasswordLogin);
            System.out.println(login);
        } while (login.equals("Email or Password incorrect") || login.equals("User Not Exists"));
        User userLogged = authService.GetUserByEmail(inputEmailLogin);
        UUID session_id = UUID.randomUUID();
        Session session = new Session(session_id, userLogged.getId(), userLogged.getEmail(), LocalDateTime.now(), LocalDateTime.now(), true);
        sessionService.createSession(session);
        showAccountMenu(userLogged);
    }

    public void showAccountMenu(User userLogged) {
        int inputSelect = 0;
        do {
            System.out.println("==========================================");
            System.out.println("               CONNECTÉ                 ");
            System.out.println("==========================================");
            System.out.println(" Connecté en tant que : " + userLogged.getFullName());
            System.out.println("==========================================");
            System.out.println(" 1  :  Créer un compte");
            System.out.println(" 2  :  Liste de mes comptes");
            System.out.println(" 3  :  Dépôt");
            System.out.println(" 4  :  Retrait");
            System.out.println(" 5  :  Virement");
            System.out.println(" 6  :  Historique des transactions");
            System.out.println(" 7  :  Mettre à jour le profil");
            System.out.println(" 8  :  Changer le mot de passe");
            System.out.println(" 9  :  Fermer un compte");
            System.out.println("10  :  Logout");
            System.out.println("11  :  Quitter l’application");
            System.out.println("==========================================");
            System.out.print("➡ Veuillez choisir une option : ");
            inputSelect = new Scanner(System.in).nextInt();
            switch (inputSelect) {
                case 1:
                    this.createAccount(userLogged.getId());
                    break;
                case 2:
                    this.listAccounts(userLogged.getId());
                    break;
                case 3:

                case 6:
                    this.getTransactionsHistory(userLogged.getId());
                    break;
                case 7:
                    this.updateProfile(userLogged.getEmail());
                    break;
                case 10:
                    this.run();
                    this.sessionService.destroySession();
                    break;
            }


        } while (inputSelect != 11);

    }

    public void createAccount(UUID user_id) {
        Account accountCreation = new Account(user_id);
      Account accountCreated =  this.accountService.createAccount(accountCreation);
        System.out.println("compte créer avec succées");
        System.out.println("numero compte : " + " " + accountCreated.getAccountId());
        System.out.print("↩ Retourner au menu principal ? (Y) : ");
        String inputChoix = new Scanner(System.in).nextLine();
    }

    public void listAccounts(UUID user_id) {
        List<Account> accountsUser = this.accountService.getAllAccounts(user_id);
        System.out.println("==========================================");
        System.out.println("           LISTE DE VOS COMPTES         ");
        System.out.println("==========================================");
        for (Account accountUser : accountsUser) {
            System.out.printf("%-15s %-15s %-20s %-10s%n",
                    "Numero Compte", "Balance", "Date de création", "Actif");
            System.out.println("---------------------------------------------------------------");
            System.out.printf("%-15s %-15.2f %-20s %-10s%n",
                    accountUser.getAccountId(),
                    accountUser.getBalance(),
                    accountUser.getCreatedAt(),
                    accountUser.getActive());
        }
        System.out.println("==========================================");
        System.out.print("↩ Retourner au menu principal ? (Y) : ");
        String inputChoix = new Scanner(System.in).nextLine();
    }

    public void closeAccount() {
        String inputCompte;
        do {
            System.out.println("entrer numéro compte :");
            inputCompte = new Scanner(System.in).nextLine();
            this.accountService.closeAccount(inputCompte);
        } while (this.accountService.closeAccount(inputCompte))
    }

    public void updateProfile(String email) {
        System.out.println("==========================================");
        System.out.println("            UPDATE PROFILE             ");
        System.out.println("==========================================");
        System.out.println(" Que souhaitez-vous mettre à jour ? ");
        System.out.println("------------------------------------------");
        System.out.println(" 1 :  Email");
        System.out.println(" 2 :  Adresse");
        System.out.println("==========================================");
        int inputChoix = new Scanner(System.in).nextInt();
        switch (inputChoix) {
            case 1:
                System.out.println(" Entrer votre nouvelle Email ? ");
                String inputnewEmail = new Scanner(System.in).nextLine();
                System.out.println(this.userService.updateEmailUser(email, inputnewEmail));
                System.out.print("↩ Retourner au menu principal ? (Y) : ");
                String inputlo = new Scanner(System.in).nextLine();
                break;
            case 2:
                System.out.println(" Entrer votre nouvelle Adresse ? ");
                String inputnewAdresse = new Scanner(System.in).nextLine();
                this.userService.updateAdresseUser(email, inputnewAdresse);
                System.out.print("↩ Retourner au menu principal ? (Y) : ");
                String inputsolo = new Scanner(System.in).nextLine();
                break;


        }


    }

    public void depotArgent(String accountId, BigDecimal amount)
    {

    }

    public void getTransactionsHistory(UUID user_id) {
        List<Transaction> transactions = this.transactionService.getAllTransactionsByUser(user_id);

        System.out.println("==========================================");
        System.out.println("           HISTORIQUE DES TRANSACTIONS   ");
        System.out.println("==========================================");

        for (Transaction transaction : transactions) {
            System.out.printf("%-40s %-20s %-15s %-36s%n",
                    "ID Transaction", "Date / Heure", "Compte", "Amount");
            System.out.println("-------------------------------------------------------------------------------");
            System.out.printf("%-40s %-20s %-15s %-36s%n %-15s%n",
                    transaction.getId(),
                    transaction.getInstant(),
                    transaction.getAccountId(),
                    transaction.getAmount());

            System.out.println("-------------------------------------------------------------------------------");
        }
        System.out.print("↩ Retourner au menu principal ? (Y) : ");
        String inputsolo = new Scanner(System.in).nextLine();
    }
}

