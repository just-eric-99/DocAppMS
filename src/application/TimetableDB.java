package application;

public class TimetableDB {

    private void formattedName(String name) {
        // length of 11
        int wholeLength = 11;
        if (name.length() == wholeLength) {
            System.out.print(name);
        } else if (name.length() > wholeLength) {
            String formatName = "";
            for (int i = 0; i < wholeLength; i++) {
                formatName += name.charAt(i);
            }
            System.out.print(formatName);
        } else {
            int lengthOfName = 0;
            int spacing = 0;
            String space = " ";
            for (int i = 0; i < name.length(); i++) {
                lengthOfName++;
            }
            if (lengthOfName % 2 == 1) {
                spacing = (int) (0.5 * (11 - name.length()));
            } else if (lengthOfName % 2 == 0) {
                spacing = (int) (5 - ((name.length() / 2) - 1));
            }
            for (int i = 0; i < spacing; i++) {
                System.out.print(" ");
            }
            System.out.printf("%s", name);
            if (lengthOfName % 2 == 0) {
                spacing--;
            }
            for (int i = 0; i < spacing; i++) {

                System.out.print(" ");
            }
        }
    }

    public void timetable(String[][] clientInfo) {
        System.out.println();
        System.out.print("\t ");
        formattedName("Monday");
        System.out.print(" ");
        formattedName("Tuesday");

        System.out.print(" ");
        formattedName("Wednesday");

        System.out.print(" ");
        formattedName("Thursday");

        System.out.print(" ");
        formattedName("Friday\n");
        System.out.println("\t+-----------+-----------+-----------+-----------+-----------+");
        System.out.println("\t|           |           |           |           |           |");
        System.out.print(" 9\t|");

        boolean isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("M09")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("T09")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("W09")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("R09")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("F09")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("| 9\n");


        System.out.println("\t|           |           |           |           |           |");
        System.out.println("\t+-----------+-----------+-----------+-----------+-----------+");
        System.out.println("\t|           |           |           |           |           |");
        System.out.print("10\t|");

        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("M10")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("T10")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("W10")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("R10")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("F10")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("| 10\n");

        System.out.println("\t|           |           |           |           |           |");
        System.out.println("\t+-----------+-----------+-----------+-----------+-----------+");
        System.out.println("\t|           |           |           |           |           |");
        System.out.print("11\t|");

        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("M11")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("T11")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("W11")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("R11")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("F11")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("| 11\n");
        System.out.println("\t|           |           |           |           |           |");
        System.out.println("\t+-----------+-----------+-----------+-----------+-----------+");
        System.out.println("\t|           |           |           |           |           |");

        System.out.print("12\t|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("M12")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("T12")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("W12")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("R12")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("F12")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("| 12\n");

        System.out.println("\t|           |           |           |           |           |");
        System.out.println("\t+-----------+-----------+-----------+-----------+-----------+");
        System.out.println("\t|           |           |           |           |           |");

        System.out.print("13\t|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("M13")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("T13")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("W13")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("R13")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("F13")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("| 13\n");

        System.out.println("\t|           |           |           |           |           |");
        System.out.println("\t+-----------+-----------+-----------+-----------+-----------+");
        System.out.println("\t|           |           |           |           |           |");

        System.out.print("14\t|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("M14")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("T14")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("W14")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("R14")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("F14")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("| 14\n");

        System.out.println("\t|           |           |           |           |           |");
        System.out.println("\t+-----------+-----------+-----------+-----------+-----------+");
        System.out.println("\t|           |           |           |           |           |");

        System.out.print("15\t|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("M15")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("T15")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("W15")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("R15")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("F15")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("| 15\n");


        System.out.println("\t|           |           |           |           |           |");
        System.out.println("\t+-----------+-----------+-----------+-----------+-----------+");
        System.out.println("\t|           |           |           |           |           |");


        System.out.print("16\t|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("M16")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("T16")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("W16")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("R16")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("F16")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("| 16\n");


        System.out.println("\t|           |           |           |           |           |");
        System.out.println("\t+-----------+-----------+-----------+-----------+-----------+");
        System.out.println("\t|           |           |           |           |           |");


        System.out.print("17\t|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("M17")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("T17")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("W17")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("R17")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("F17")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("| 17\n");


        System.out.println("\t|           |           |           |           |           |");
        System.out.println("\t+-----------+-----------+-----------+-----------+-----------+");
        System.out.println("\t|           |           |           |           |           |");


        System.out.print("18\t|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("M18")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("T18")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("W18")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("R18")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("|");
        isOccupied = false;
        for (int i = 0; i < clientInfo.length; i++) {
            if (clientInfo[i][1].equals("F18")) {
                formattedName(clientInfo[i][0]);
                isOccupied = true;
                break;
            }
        }
        if (!isOccupied) {
            System.out.print("           ");
        }
        System.out.print("| 18\n");

        System.out.println("\t|           |           |           |           |           |");
        System.out.println("\t+-----------+-----------+-----------+-----------+-----------+");
        System.out.print("\t ");
        formattedName("Monday");
        System.out.print(" ");
        formattedName("Tuesday");

        System.out.print(" ");
        formattedName("Wednesday");

        System.out.print(" ");
        formattedName("Thursday");

        System.out.print(" ");
        formattedName("Friday\n");

        System.out.println();
    }
}
