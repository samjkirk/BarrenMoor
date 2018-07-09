import java.util.Scanner;

public class GameLoop extends MainGame {
    private Scanner sc = new Scanner(System.in);
    private boolean northRuined;
    private boolean eastRuined;
    private boolean westRuined;

    // Start of game... pick name and make first move
    public Boolean startGame() {
        Player player1 = new Player("NONE", "NONE", 10,0.0, 0.0, 0.0, 0.0);
        String tempName;
        System.out.println("You awaken to find yourself in a barren moor.");
        System.out.println("Try 'look'");
        String input = sc.nextLine();

        // validation: "look"
        while (!input.equals("look")) {
            System.out.println("Try 'look'");
            input = sc.nextLine();
        }

        System.out.println("Grey foggy clouds float oppressively close to you," +
                "\nreflected in the murky grey water which reaches up your " +
                "\nshins.");
        System.out.println("You glance down at your chest and see a torn name badge" +
                "\nwith something scrawled on it...");
        System.out.println("Enter your name: ");
        tempName = sc.nextLine();

        // validation: Name is less than 8 characters
        while (tempName.length()>=8) {
            System.out.println("Please Enter a name that is 8 characters or less...");
            tempName = sc.nextLine();
        }
        createNewPlayer(player1, tempName);


        System.out.println("As you begin to survey the seemingly endless landscape" +
                "\nthat surrounds you, you notice a small pulsing" +
                "\ndevice in your right hand that seems to resemble a compass.");

        // Move
        String move = playerMovement();
        while (move.equals("Invalid")){
            move = playerMovement();
        }
        firstMove(move, player1);

        // When game is finished return false and ask if user wants to play again
        return false;
    }

    private void firstMove(String move, Player player1){
        String decision = "Invalid";
            // First move north
        if (move.equals("North")){
            System.out.println("The device starts flashing blue and you begin to have" +
                    "\nsecond thoughts about heading in this direction...");
            while (decision.equals("Invalid")){
                System.out.println("Do you wish to continue? Try 'Y' or 'N'");
                decision = sc.nextLine();
                if (decision.equals("Y")){
                    System.out.println("You head North");
                    player1.setDistanceFromOriginNorth(100.00);
                    northernPath(player1);
                } else if (decision.equals("N")) {
                    System.out.println("You decide to head back to where you were...");
                    move = playerMovement();
                    while (move.equals("Invalid")){
                        move = playerMovement();
                    }
                    firstMove(move, player1);
                } else {
                    decision = "Invalid";
                }
            }
            // First move south
        } else if (move.equals("South")){
            System.out.println("The device starts flashing green..." +
                    "\nWhich can only be a good thing, right?");
            while (decision.equals("Invalid")){
                System.out.println("Do you wish to continue? Try 'Y' or 'N'");
                decision = sc.nextLine();
                if (decision.equals("Y")){
                    System.out.println("You head South");
                    player1.setDistanceFromOriginSouth(100.00);
                    southernPath(player1);
                } else if (decision.equals("N")) {
                    System.out.println("You decide to head back to where you were..");
                    move = playerMovement();
                    while (move.equals("Invalid")){
                        move = playerMovement();
                    }
                    firstMove(move, player1);
                } else {
                    decision = "Invalid";
                }
            }
            // First move East
        } else if (move.equals("East")){
            System.out.println("The device starts flashing red..." +
                    "\nthat can't be good.");
            while (decision.equals("Invalid")){
                System.out.println("Do you wish to continue? Try 'Y' or 'N'");
                decision = sc.nextLine();
                if (decision.equals("Y")){
                    player1.setDistanceFromOriginEast(100.00);
                    easternPath(player1);
                } else if (decision.equals("N")) {
                    System.out.println("You decide to head back to where you started...");
                    move = playerMovement();
                    while (move.equals("Invalid")){
                        move = playerMovement();
                    }
                    firstMove(move, player1);
                } else {
                    decision = "Invalid";
                }
            }
            // First move west
        } else if (move.equals("West")){
            System.out.println("The device begins to shake in your hand..." +
                    "\nmaybe heading west wasn't such a good idea.");
            while (decision.equals("Invalid")){
                System.out.println("Do you wish to continue? Try 'Y' or 'N'");
                decision = sc.nextLine();
                if (decision.equals("Y")){
                    player1.setDistanceFromOriginEast(100.00);
                    westernPath(player1);
                } else if (decision.equals("N")) {
                    System.out.println("You decide to head back to where you woke up...");
                    move = playerMovement();
                    while (move.equals("Invalid")){
                        move = playerMovement();
                    }
                    firstMove(move, player1);
                } else {
                    decision = "Invalid";
                }
            }
        }
    }

    private void createNewPlayer(Player player, String name) {
        player.setName(name);
        System.out.println("'" + name + "'" + "... That must be me, you think to yourself.");
    }

    private String playerMovement() {
        System.out.println("Which way would you like to go?");
        System.out.println("Try 'North', 'South', 'East', or 'West',");
        String nesw = sc.nextLine();

        switch (nesw){
            case "North":
                if (!northRuined) {
                    System.out.println("You turn until the device shows a large 'N'" +
                            "\nand start walking.");
                    return "North";
                } else {
                    System.out.println("Everything to the north fell into the abyss!" +
                            "\nYou'll have to pick another way to go");
                    return "Invalid";
                }
            case "South":
                System.out.println("You turn until the device shows a large 'S'" +
                        "\nand start walking.");
                return "South";
            case "East":
                if (!eastRuined) {
                    System.out.println("You turn until the device shows a large 'E'" +
                            "\nand start walking.");
                    return "East";
                } else {
                    System.out.println("You've explored everything there is to the east..." +
                            "\nYou should probably try another direction.");
                    return "Invalid";
                }
            case "West":
                if (!westRuined){
                    System.out.println("You turn until the device shows a large 'W'" +
                            "\nand start walking.");
                    return "West";
                } else {
                    System.out.println("There's no chance I'm going back there, you think " +
                            "\nto yourself. Better try another direction.");
                    return "Invalid";
                }
                default: return "Invalid";
        }
    }

    private void northernPath(Player player1){
        String interact;
        System.out.println("After walking for what feels like a life time, you" +
                "\ncome across a shallow river..." +
                "\nyou spot something glowing under the murky waters' surface..");
        do {
            System.out.println("Interact? Try 'Y' or 'N'");
            interact = sc.nextLine();
            if (interact.equals("Y")) {
                player1.setWeapon("Rusty Sword");
                System.out.println("You obtained a 'Rusty Sword'!!\n" + player1.toString(player1) +
                        "\nIt's seen better days but it'll do the job.." +
                        "\nAs you examine your new sword you feel the ground start to shake beneath you.." +
                        "\nYou quickly start sprinting back the way you came as the ground starts to" +
                        "\nfall away chunk by chunk." +
                        "\nThank fully you make it out unscathed, and it looks as though you're right " +
                        "back where you started.");
                northRuined = true;
                String move = playerMovement();
                while (move.equals("Invalid")){
                    move = playerMovement();
                }
                firstMove(move, player1);
                break;
            } else if (interact.equals("N")) {
                System.out.println("You decide it's probably best to leave the strange glowing object\nand head back to where you woke up...");
                player1.setDistanceFromOriginNorth(0.0);
                String move = playerMovement();
                while (move.equals("Invalid")){
                    move = playerMovement();
                }
                firstMove(move, player1);
                break;
            }
        } while (!interact.equals("Y")||!interact.equals("N"));
    }

    private void southernPath(Player player1){
        Enemy troll = new Troll(true, 20, "Hammer");
        String interact;

        System.out.println("After wading through the water for what feels like a lifetime," +
                "\nyou finally come across solid ground." +
                "\nThe ground starts to tremble beneath you as a huge troll like best" +
                "\nascends from the ground in front of you!" +
                "\nDo you stay and fight?");
        System.out.println("TROLL" +
                "\nTroll Health: " + troll.getHealth(troll));
        do {
            System.out.println("Try 'Y' or 'N'");
            interact = sc.nextLine();
            if (interact.equals("Y")&&player1.getWeapon(player1).equals("Rusty Sword")) {
                System.out.println("You charge the troll as you unsheathe your trusty sword and begin hacking at the trolls legs" +
                        "\nYou manage to stay undeath the troll and avoid all of its attacks." +
                        "\nThe troll lets out a huge groan and falls to the ground!\n");
                troll.setHealth(0);
                troll.setAlive(false);
                System.out.println("Troll Health -20.\n" + "Troll current health: " + troll.health +
                        "\nCongratulations! You've defeated the troll!\n" +
                        "Suddenly the compass device flies out of your hand straight up into the sky..\n" +
                        "After a few seconds a blinding light erupts from the compass" +
                        "\nthat forces you to close your eyes." +
                        "\nAs you open them again, you realise you're back in you're own bed," +
                        "\nsafe and sound... it was all a dream.\n");
                break;
            } else if (interact.equals("Y")&&!player1.getWeapon(player1).equals("Rusty Sword")) {
                System.out.println("The troll immediately swings his giant hammer crushing you in one swift move..." +
                        "\nYou should have been more prepared..." +
                        "\nGAME OVER");
                break;
            } else if (interact.equals("N")) {
                System.out.println("You turn around and don't stop running until you find yourself right back where you started...");
                player1.setDistanceFromOriginSouth(0.0);
                String move = playerMovement();
                while (move.equals("Invalid")){
                    move = playerMovement();
                }
                firstMove(move, player1);
                break;
            }
        } while (!interact.equals("Y")||!interact.equals("N"));
    }

    private void easternPath(Player player1) {
        String interact;

        System.out.println("The fog starts to clear and you spot what looks like a single" +
                "\ntree on top of a small dirt mound." +
                "\nWith closer inspection you see the tree is in fact an apple tree." +
                "\nYou can't remember the last time you ate but who knows" +
                "\nwhat could happen if you tried one of these apples." +
                "\nThis feels like a trap.");

        do {
            System.out.println("Try the apple? 'Y' or 'N'");
            interact = sc.nextLine();
            if (interact.equals("Y")) {
                System.out.println("You slowly approach the tree and pick one of the apples from" +
                        "\na low hanging branch." +
                        "\nAs you take your first bite you start to feel woozy. Before you" +
                        "\nknow it your eyes begin to flicker and you feel yourself loosing" +
                        "\nconsciousness...");
                player1.setHealth(player1.getHealth(player1)+5);
                System.out.println("You wake up feeling invigorated, but you seem to be right back" +
                        "\nwhere you started...");
                System.out.println("Player health + 5!" +
                        "\nCurrent health: " + player1.getHealth(player1));
                eastRuined = true;
                String move = playerMovement();
                while (move.equals("Invalid")){
                    move = playerMovement();
                }
                firstMove(move, player1);
                break;
            } else if (interact.equals("N")) {
                System.out.println("Something's not right about this tree... You decide to head back to" +
                        "\nwhere you started.");
                player1.setDistanceFromOriginEast(0.0);
                String move = playerMovement();
                while (move.equals("Invalid")){
                    move = playerMovement();
                }
                firstMove(move, player1);
            }
        } while (!interact.equals("Y")||!interact.equals("N"));
    }

    private void westernPath(Player player1){
        String interact;

        System.out.println("After almost an hour of walking you come across a thick forest." +
                "\nThe air around you starts to get cold and voices begin coming from the fog" +
                "\ntelling you to 'turn back'." +
                "\nTurn around and go back?");

        do {
            System.out.println("'Y' or 'N'");
            interact = sc.nextLine();
            if (interact.equals("Y")) {
                System.out.println("You decide it's probably best to listen to the mystical voices," +
                        "\nthey seem to know their stuff!" +
                        "\nYou turn around and begin the long walk back to where" +
                        "\nyou started.");
                player1.setDistanceFromOriginWest(0.0);
                westRuined = true;
                String move = playerMovement();
                while (move.equals("Invalid")){
                    move = playerMovement();
                }
                firstMove(move, player1);
                break;
            } else if (interact.equals("N")) {
                System.out.println("You decide not to listen to the scary voices and begin venturing through the forest." +
                        "\n'It can't be that bad' you think to yourself..." +
                        "\nAs time passes you realise you've been going in circles for hours," +
                        "\nmaybe even days! There's no chance of you getting back out." +
                        "\nYou lay down and close your eyes...");
                System.out.println("GAME OVER");
                break;
            }
        } while (!interact.equals("Y")||!interact.equals("N"));
    }

    public void checkStats(Player player){
        System.out.println();
        System.out.println(player.toString(player));
    }
}
