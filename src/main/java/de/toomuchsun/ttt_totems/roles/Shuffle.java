package de.toomuchsun.ttt_totems.roles;

import de.toomuchsun.ttt_totems.roles.ticket.TicketHandler;

public class Shuffle {
    private static int maxInnocent = 0;
    private static int maxDetective = 0;
    private static int maxTraitor = 0;
    private static int size = 0;
    private static boolean b_totemhunter = false;
    private static boolean b_jackal = false;
    private static boolean b_shinigami = false;

    private static int countInnocent = 0;
    private static int countDetective = 0;
    private static int countTraitor = 0;
    private static int countAdmin = 0;
    private static boolean existTotemhunter = false;
    private static boolean existJackal = false;
    private static boolean existShinigami = false;

    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        Shuffle.size = size;
    }


    public static int getMaxInnocent() {
        return maxInnocent;
    }

    public static void setMaxInnocent(int maxInnocent) {
        Shuffle.maxInnocent = maxInnocent;
    }

    public static int getMaxDetective() {
        return maxDetective;
    }

    public static void setMaxDetective(int maxDetective) {
        Shuffle.maxDetective = maxDetective;
    }

    public static int getMaxTraitor() {
        return maxTraitor;
    }

    public static void setMaxTraitor(int maxTraitor) {
        Shuffle.maxTraitor = maxTraitor;
    }

    public static boolean isB_totemhunter() {
        return b_totemhunter;
    }

    public static void setB_totemhunter(boolean b_totemhunter) {
        Shuffle.b_totemhunter = b_totemhunter;
    }

    public static boolean isB_jackal() {
        return b_jackal;
    }

    public static void setB_jackal(boolean b_jackal) {
        Shuffle.b_jackal = b_jackal;
    }

    public static boolean isB_shinigami() {
        return b_shinigami;
    }

    public static void setB_shinigami(boolean b_shinigami) {
        Shuffle.b_shinigami = b_shinigami;
    }

    public static int getCountInnocent() {
        return countInnocent;
    }

    public static void setCountInnocent(int countInnocent) {
        Shuffle.countInnocent = countInnocent;
    }

    public static int getCountDetective() {
        return countDetective;
    }

    public static void setCountDetective(int countDetective) {
        Shuffle.countDetective = countDetective;
    }

    public static int getCountTraitor() {
        return countTraitor;
    }

    public static void setCountTraitor(int countTraitor) {
        Shuffle.countTraitor = countTraitor;
    }

    public static boolean isExistTotemhunter() {
        return existTotemhunter;
    }

    public static void setExistTotemhunter(boolean existTotemhunter) {
        Shuffle.existTotemhunter = existTotemhunter;
    }

    public static boolean isExistJackal() {
        return existJackal;
    }

    public static void setExistJackal(boolean existJackal) {
        Shuffle.existJackal = existJackal;
    }

    public static boolean isExistShinigami() {
        return existShinigami;
    }

    public static void setExistShinigami(boolean existShinigami) {
        Shuffle.existShinigami = existShinigami;
    }

    public static int getCountAdmin() {
        return countAdmin;
    }


    public static void updateCount(){


        TicketHandler.check();
    }



    //    public static void resetVar(){
//        b_totemhunter = Var.getAllowTotemhunter();
//        b_jackal = Var.getAllowJackal();
//        b_shinigami = Var.getAllowShinigami();
//        maxInnocent = 0;
//        maxDetective = 0;
//        maxTraitor = 0;
//        size = Bukkit.getOnlinePlayers().size();
//    }
//
//    public static void checkCount(){
//        resetVar();
//
//        for (int i = 0; i < size; i++){
//            if (i/size <= 0.25){
//                if (b_totemhunter && size >= 8){
//                    maxTraitor--;
//                }
//                maxTraitor++;
//            } else if (i/size <= 0.417){
//                maxDetective++;
//            } else {
//                maxInnocent++;
//            }
//        }
//    }
//
//    public static void shuffleRoles() {
//        int size = Bukkit.getOnlinePlayers().size();
//        int index = 0;
//        boolean totemhunter = Var.getAllowTotemhunter();
//        boolean jackal = Var.getAllowJackal();
//        boolean shinigami = Var.getAllowShinigami();
//        ArrayList<Role> role = new ArrayList<>();
//
//        for (int i = 0; i < size; i++){
//            if (i/size <= 0.25){
//                if (totemhunter && size >= 8){
//                    role.add(Role.TOTEMHUNTER);
//                }
//                role.add(Role.TRAITOR);
//            } else if (i/size <= 0.417){
//                role.add(Role.DETECTIVE);
//            } else if (jackal && size >= 4){
//                role.add(Role.JACKAL);
//            } else if (shinigami && size >=4){
//                role.add(Role.SHINIGAMI);
//                //TODO setDeathGrip();
//            } else {
//                role.add(Role.INNOCENT);
//            }
//        }
//
//        Collections.shuffle(role);
//
//
//
//        for (Player p : Bukkit.getOnlinePlayers()){
//            RoleHandler.assignRole(p, role.get(index));
//            index++;
//        }
//    }
}
