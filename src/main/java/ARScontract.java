import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ARScontract {
    private static Stack<String> arsStack;
    private static String  contractID;
    private static String  type;
    private static String  domicile;
    private static String  dates;
    private static String  tractorsPerWeek;
    private static String  certificationsReqired;
    private static String  driverType;
    private static String  blocksPerTractorPerWeek;
    private static String  totalPay;
    private static String  infoLink;

    public ARScontract(String messageBody) {
        buildARSstack(messageBody);
        setVariables();
    }

    private void setVariables() {

        infoLink = arsStack.pop();
        totalPay = arsStack.pop();
        blocksPerTractorPerWeek = arsStack.pop();
        driverType = arsStack.pop();
        certificationsReqired = arsStack.pop();
        tractorsPerWeek = arsStack.pop();
        dates = arsStack.pop();
        domicile = arsStack.pop();
        type = arsStack.pop();
        contractID = arsStack.pop();
    }

    private static void buildARSstack(String s) {
        /*this class is to parse the contact info from the decoded message from Gmail API*/
        Scanner scanner = new Scanner(s);
        arsStack = new Stack<>();
        String line = "";
        //skip to line 13 in message
        for (int j = 0; j < 12; j++) {
            scanner.nextLine();
        }
        for (int i = 0; i < 9; i++) {
            scanner.nextLine();
            arsStack.push(scanner.nextLine());
        }
        scanner.nextLine();
        scanner.nextLine();
        arsStack.push(scanner.nextLine());
        scanner.close();
    }

    public String getContractID() {
        return contractID;
    }

    public String getType() {
        return type;
    }

    public static String getDomicile() {
        return domicile;
    }

    public static String getDates() {
        return dates;
    }

    public static String getTractorsPerWeek() {
        return tractorsPerWeek;
    }

    public static String getCertificationsReqired() {
        return certificationsReqired;
    }

    public static String getDriverType() {
        return driverType;
    }

    public static String getBlocksPerTractorPerWeek() {
        return blocksPerTractorPerWeek;
    }

    public static String getTotalPay() {
        return totalPay;
    }

    public static String getInfoLink() {
        return infoLink;
    }

}
