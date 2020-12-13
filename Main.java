import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        List<Cargo> cargos = new ArrayList<>();

        Scanner s = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("==Cargo Manager==");
        if (cargos.size() < 1) {
            System.out.println("Cargo is empty!");
        }
        int choose = 0;
        try {

            while (choose < 5) {
                menu();
                System.out.print("enter: ");
                choose = s.nextInt();

                if (choose == 1) {
                    String id = "";
                    int volume = 0;
                    String contents = "";
                    String hazzard = "";
                    String hazzardous = "";
                    while (volume <= 0) {
                        System.out.print("input volume [must be more than 0]: ");
                        volume = Integer.parseInt(br.readLine());
                    }

                    if (volume > 0) {
                        while (contents == "") {
                            System.out.print("Input contents [char 1..10]:");
                            contents = br.readLine();
                        }

                        if (contents != "") {
                            System.out.print("Is content hazzardous? [yes/no] ");
                            String ans = br.readLine();

                            if (ans.equals("yes")) {
                                hazzardous = "yes";
                                if (!hazzard.equals("Brittle") || !hazzard.equals("Flammable")
                                        || !hazzard.equals("Poisonous")) {
                                    System.out.print("Hazard type [Brittle | Flammable | Poisonous] ");
                                    hazzard = br.readLine();
                                    System.out.println(hazzard);
                                }

                            } else {
                                hazzardous = "no";
                                hazzard = "NonHazzardous";
                            }

                        }
                    }

                    int index = 1;
                    while (index <= cargos.size()) {
                        index++;
                    }

                    id = id + String.valueOf(index) + "00" + String.valueOf(volume);

                    try {

                        Cargo newCargo = new Cargo(id, volume, HazzardType.valueOf(hazzard), contents, hazzardous);

                        cargos.add(newCargo);

                        System.out.println("Cargo ID: " + newCargo.getId());
                        System.out.println("Cargo has been added!");
                        System.out.println("======================");
                        printCargo(newCargo);

                    } catch (Exception e) {

                    }

                } else if (choose == 2) {
                    if (cargos.size() > 0) {
                        String cargoId = "";
                        System.out.println("your Cargo");
                        System.out.println("======================");
                        for (Cargo cargo : cargos) {
                            printCargo(cargo);
                        }
                        System.out.print("Input Cargo ID for update: ");
                        cargoId = br.readLine();
                        Cargo thisCargo = new Cargo();
                        for (Cargo cargo : cargos) {
                            if (cargoId.equals(cargo.getId())) {
                                thisCargo = cargo;
                            }
                        }

                        System.out.println("What do you want to update?");
                        System.out.println("1. contents");
                        System.out.println("2. volume");
                        System.out.print("choose: ");
                        String choice = br.readLine();
                        switch (choice) {
                            case "1":
                                System.out.print("Input correct contents: ");
                                String content = br.readLine();
                                thisCargo.setContent(content);
                                System.out.println("Cargo content was updated!");
                                break;
                            case "2":
                                System.out.print("Input correct volume: ");
                                Integer volume = Integer.parseInt(br.readLine());
                                thisCargo.setVolume(volume);
                                System.out.println("Cargo volume was updated!");
                                break;
                            default:
                                System.out.println("Wrong choice!");
                                break;
                        }
                    } else {
                        System.out.println("Cargo is empty!");
                    }
                } else if (choose == 3) {

                    if (cargos.size() > 0) {
                        String shipId = "";
                        System.out.println("your Cargo");
                        System.out.println("======================");
                        for (Cargo cargo : cargos) {
                            printCargo(cargo);
                        }
                        System.out.print("Input Cargo ID: ");
                        shipId = br.readLine();
                        Cargo thisCargo = new Cargo();

                        for (Cargo cargo : cargos) {
                            if (shipId.equals(cargo.getId())) {
                                thisCargo = cargo;
                            }
                        }
                        thisCargo.shipCargo(shipId);
                        cargos.remove(thisCargo);
                    } else {
                        System.out.println("Cargo is empty!");
                    }

                } else if (choose == 4) {
                    System.out.println("List of Cargos");
                    System.out.println("======================");
                    if (cargos.size() > 0) {
                        for (Cargo cargo : cargos) {
                            printCargo(cargo);
                        }
                    } else {
                        System.out.println("There is no cargo!");
                    }
                } else if (choose == 5) {
                    System.out.println("you are quit!");
                    s.close();
                }

            }
        } catch (Exception e) {
            System.out.println("Wrong input!");
        }
    }

    public static void menu() {
        System.out.println("1. Add cargo");
        System.out.println("2. Update existing cargo");
        System.out.println("3. Ship cargo");
        System.out.println("4. List of cargos");
        System.out.println("5. Exit");
    }

    public static void printCargo(Cargo newCargo) {
        System.out.println("Id = " + newCargo.getId());
        System.out.println("Volume = " + newCargo.getVolume());
        System.out.println("Contents = " + newCargo.getContent());
        System.out.println("Hazzardous = " + newCargo.getHazzardous());
        System.out.println("HazardType = " + newCargo.getHazzard());
        System.out.println("======================");
    }

    public static void shipCargo(Cargo cargo, String id) {
        if (id.equals(cargo.getId())) {
            System.out.println("Cargo is been shipped");
        } else {
            System.out.println("ID is not exist");
        }
    }
}