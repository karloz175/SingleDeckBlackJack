package app;

import data.Deck;
import logic.BlackjackGame;
import logic.MoneyManagement;

import java.util.InputMismatchException;
import logic.CantDepositLessThanZeroException;
import java.util.Scanner;

public class Casino {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MoneyManagement money = new MoneyManagement();

        final int STARTING_NUMBER_OF_CARDS = 0;
        final int MAX_CARDS_TO_21 = 11;

        System.out.println("Welcome to the casino!");
        System.out.println("Please deposit money! How much would you like to deposit?");
        boolean error = true;
        double moneyToDeposit = 0;
        while(error){
            try{
                moneyToDeposit = sc.nextDouble();
                if(moneyToDeposit<0)
                    throw new CantDepositLessThanZeroException("You can't divide by 0. Try again.");


                sc.nextLine();
                money.depositGuestMoney(moneyToDeposit);

                error = false;
            } catch (InputMismatchException e){
                System.out.println("Please enter a valid number.");
                sc.nextLine();
            } catch (CantDepositLessThanZeroException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }

        }



        System.out.printf("Thanks for depositing %.2f$%n",money.getGuestMoney());

        System.out.println("Welcome to Single Deck Blackjack Game!");
        System.out.println("Do you want to start a game(yes/no)?");
        error = true;
        while(error){
            try{
                String doYouWantToPlay = sc.nextLine();
                if(doYouWantToPlay.equalsIgnoreCase("yes")){
                    BlackjackGame blackjackGame = new BlackjackGame();
                    Deck[] deckToPlay = blackjackGame.newshuffledDeck();

                    boolean doWeStillPlay = true;

                    int deckCardId = STARTING_NUMBER_OF_CARDS;

                    while(doWeStillPlay){

                        int playerCardId = STARTING_NUMBER_OF_CARDS;
                        int croupierCardId = STARTING_NUMBER_OF_CARDS;
                        int playerAllCardsValue = 0;
                        int croupierAllCardsValue = 0;
                        Deck[] playerCards = new Deck[MAX_CARDS_TO_21];
                        Deck[] croupierCards = new Deck[MAX_CARDS_TO_21];
                        double bet = 0;
                        String operation;
                        String winner;

                        boolean doWeHitOrDouble = false;

                        int croupierCheckingForAce = STARTING_NUMBER_OF_CARDS;
                        int playerCheckingForAce = STARTING_NUMBER_OF_CARDS;

                        StringBuilder playerCardsString = new StringBuilder();
                        StringBuilder croupierCardsString = new StringBuilder();

                        System.out.println("How much do you bet?");
                        bet = sc.nextDouble();
                        sc.nextLine();
                        money.guestloseMoney(bet);
                        System.out.println("Your bet is " + bet + "$. On your account you have now " + money.getGuestMoney() + "$.");

                        playerCards[playerCardId] = deckToPlay[deckCardId];
                        playerAllCardsValue = playerAllCardsValue + playerCards[playerCardId].getValue();
                        playerCardsString.append("You have ");
                        playerCardsString.append(playerCards[playerCardId].name());
                        playerCardId++;
                        deckCardId++;
                        croupierCards[croupierCardId] = deckToPlay[deckCardId];
                        croupierAllCardsValue = croupierAllCardsValue + croupierCards[croupierCardId].getValue();
                        croupierCardsString.append("Crouper has ");
                        croupierCardsString.append(croupierCards[croupierCardId].name());
                        croupierCardId++;
                        deckCardId++;
                        playerCards[playerCardId] = deckToPlay[deckCardId];
                        playerAllCardsValue = playerAllCardsValue + playerCards[playerCardId].getValue();
                        if(playerAllCardsValue>21) {
                            for (int i = playerCheckingForAce; i < playerCardId; i++) {
                                if (playerCards[i].getValue() == 11)
                                    playerAllCardsValue = playerAllCardsValue - 10;
                                playerCheckingForAce = i;
                            }
                        }
                        playerCardsString.append(" and ");
                        playerCardsString.append(playerCards[playerCardId].name());
                        System.out.println(playerCardsString + " " + playerAllCardsValue);
                        System.out.println(croupierCardsString + " " + croupierAllCardsValue);
                        playerCardId++;
                        deckCardId++;
                        croupierCards[croupierCardId] = deckToPlay[deckCardId];
                        croupierAllCardsValue = croupierAllCardsValue + croupierCards[croupierCardId].getValue();
                        croupierCardId++;
                        deckCardId++;


                        do {
                            System.out.println("What you want to do(STAY/HIT/DOUBLE)?");
                            operation = sc.nextLine();
                            if (operation.equalsIgnoreCase("STAY")) {
                                croupierCardsString.append(" and ");
                                croupierCardsString.append(croupierCards[croupierCardId - 1].name());
//                        System.out.println(croupierCardsString);

                                while (croupierAllCardsValue <= playerAllCardsValue && croupierAllCardsValue <= 21) {
                                    croupierCards[croupierCardId] = deckToPlay[deckCardId];
                                    croupierAllCardsValue = croupierAllCardsValue + croupierCards[croupierCardId].getValue();
                                    if (croupierAllCardsValue > 21) {
                                        for (int i = croupierCheckingForAce; i < croupierCardId; i++) {
                                            if (croupierCards[i].getValue() == 11)
                                                croupierAllCardsValue = croupierAllCardsValue - 10;
                                            croupierCheckingForAce = i;
                                        }

                                    }
                                    croupierCardsString.append(" and ");
                                    croupierCardsString.append(croupierCards[croupierCardId].name());
                                    croupierCardId++;
                                    deckCardId++;
                                    doWeHitOrDouble = false;
//                            System.out.println(croupierCardsString);
//                            System.out.println(croupierAllCardsValue);
                                }

                            } else if (operation.equalsIgnoreCase("HIT") || operation.equalsIgnoreCase("DOUBLE")) {
                                if (operation.equalsIgnoreCase("DOUBLE")) {
                                    money.guestloseMoney(bet);
                                    bet = bet * 2;
                                    System.out.println("Twój zakład został zwiększony do : " + bet + "$.");
                                }

                                playerCards[playerCardId] = deckToPlay[deckCardId];
                                playerAllCardsValue = playerAllCardsValue + playerCards[playerCardId].getValue();
                                if (playerAllCardsValue > 21) {
                                    for (int i = playerCheckingForAce; i < playerCardId; i++) {
                                        if (playerCards[i].getValue() == 11)
                                            playerAllCardsValue = playerAllCardsValue - 10;
                                        playerCheckingForAce = i;
                                    }

                                }
                                playerCardsString.append(" and ");
                                playerCardsString.append(playerCards[playerCardId].name());
                                if(playerAllCardsValue<=21){
                                    System.out.println(playerCardsString + " " + playerAllCardsValue);
                                    doWeHitOrDouble = true;
                                } else{
                                    doWeHitOrDouble = false;
                                }
                                playerCardId++;
                                deckCardId++;

                            } else {
                                System.out.println("DO EXCEPTION HERE LATER!");
                            }
                        } while (doWeHitOrDouble);

                        if ((croupierAllCardsValue > playerAllCardsValue && croupierAllCardsValue <= 21) || croupierAllCardsValue <= 21 && playerAllCardsValue > 21) {
                            money.casinowinMoney(bet);
                            winner = "croupier";
                        } else if (croupierAllCardsValue == playerAllCardsValue && playerAllCardsValue <= 21) {
                            money.guestwinMoney(bet);
                            winner = "croupier";
                        } else {
                            money.guestwinMoney(2 * bet);
                            money.casinoloseMoney(2 * bet);
                            winner = "player";
                        }
                        System.out.print(playerCardsString);
                        System.out.print(" " + playerAllCardsValue + "\n");
                        System.out.print(croupierCardsString);
                        System.out.println(" " + croupierAllCardsValue + "\n");
                        System.out.println("WINNER: " + winner + "!");

                        System.out.println("Do you want to play again(yes/no)?");
                        if (!sc.nextLine().equalsIgnoreCase("yes")){
                            doWeStillPlay = false;
                            error = false;
                        }


                    }


                } else if (doYouWantToPlay.equalsIgnoreCase("no")) {
                    System.out.println("Ok. Here is your money " + money.getGuestMoney() + "$, thanks for visiting the casino!");
                    money.withdrawGuestMoney(money.getGuestMoney());
                    error = false;
                } else {
                    throw new IllegalArgumentException("Insert yes or no!");
                }
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }


    }
}
