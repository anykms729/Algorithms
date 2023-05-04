import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadStaffData {

    public static void main(String[] args) throws Exception {
        //parsing and reading the CSV file data into the film (object) array
        // provide the path here...
        File directory = new File("./");
        String name = directory.getAbsolutePath() + "//Staff.csv";
        Scanner sc = new Scanner(new File(name));
        Staff[] staffs = new Staff[10000];

        sc.nextLine();

        int i = 0;
        String st = "";
        while (sc.hasNextLine() && i < 10000) {
            st = sc.nextLine();
            String[] data = st.split(",");
            staffs[i++] = new Staff(Integer.parseInt(data[0]), data[1], data[2], data[3], Float.parseFloat(data[4]), Float.parseFloat(data[5]));
        }
        sc.close();

        // When to read 10 staffs for Part 1 Question(2)
        // Staff[] staffs = new Staff[10];
        // sc.nextLine();
        // int i = 0;
        // String st = "";
        // while (sc.hasNextLine() && i < 10) {
        // st = sc.nextLine();
        // String[] data = st.split(",");
        // staffs[i++] = new Staff(Integer.parseInt(data[0]), data[1], data[2], data[3], Float.parseFloat(data[4]), Float.parseFloat(data[5]));}
        // sc.close();

        // When to read 100 staffs for Part 1 Question(2)
        // Staff[] staffs = new Staff[100];
        // sc.nextLine();
        // int i = 0;
        // String st = "";
        // while (sc.hasNextLine() && i < 100) {
        // st = sc.nextLine();
        // String[] data = st.split(",");
        // staffs[i++] = new Staff(Integer.parseInt(data[0]), data[1], data[2], data[3], Float.parseFloat(data[4]), Float.parseFloat(data[5]));}
        // sc.close();

        // When to read 1000 staffs for Part 1 Question(2)
        // Staff[] staffs = new Staff[1000];
        // sc.nextLine();
        // int i = 0;
        // String st = "";
        // while (sc.hasNextLine() && i < 1000) {
        // st = sc.nextLine();
        // String[] data = st.split(",");
        // staffs[i++] = new Staff(Integer.parseInt(data[0]), data[1], data[2], data[3], Float.parseFloat(data[4]), Float.parseFloat(data[5]));}
        // sc.close();

        // When to read 5000 staffs for Part 1 Question(2)
        // Staff[] staffs = new Staff[5000];
        // int i = 0;
        // sc.nextLine();
        // String st = "";
        // while (sc.hasNextLine() && i < 5000) {
        // st = sc.nextLine();
        // String[] data = st.split(",");
        // staffs[i++] = new Staff(Integer.parseInt(data[0]), data[1], data[2], data[3], Float.parseFloat(data[4]), Float.parseFloat(data[5]));}
        // sc.close();


        // Part 1 Question(2)
        // Based on different input, the time taken will be different
        Long start_Time = System.nanoTime();
        mergeSort_Wage(staffs);
        Long end_Time = System.nanoTime();
        Long elapsed_Time = end_Time - start_Time;
        System.out.println(elapsed_Time + " seconds");


        System.out.println("Before: " + Arrays.toString(staffs) + "\n");
        mergeSort_fName(staffs);
        System.out.println("After: " + Arrays.toString(staffs) + "\n");

//        Long start_Time = System.nanoTime();
//        System.out.println(binary_Search_fName(staffs, "Toni"));
//        Long end_Time = System.nanoTime();
//        Long elapsed_Time = end_Time - start_Time;
//        System.out.println(elapsed_Time + " seconds");


//        mergeSort_Completion_Rate(staffs);
//        for (int index = 0; index < staffs.length; index++) {
//            System.out.println(staffs[index].getProjectCompletionRate());
//        }


//        System.out.println(project_completion_In_Budget(staffs, 100000));
//        add_At_Last(staffs);
//        System.out.println(firstName_Exception_Handling(" jj"));
    }

    // Part 1 Question (1)
    public static void mergeSort_Wage(Staff[] staffs) {
        int length = staffs.length;

        // Base case
        if (length <= 1) return;
        int mid = length / 2;

        // Divide
        Staff[] left_Array = new Staff[mid];
        Staff[] right_Array = new Staff[length - mid];

        int l = 0, r = 0;

        for (; l < length; l++) {
            if (l < mid) {
                left_Array[l] = staffs[l];
            } else {
                right_Array[r] = staffs[l];
                r++;
            }
        }
        mergeSort_Wage(left_Array);
        mergeSort_Wage(right_Array);
        merge_Wage(left_Array, right_Array, staffs);
    }

    public static void merge_Wage(Staff[] left_Array, Staff[] right_Array, Staff[] staffs) {
        int left_Size = staffs.length / 2;
        int right_Size = staffs.length - left_Size;
        int l = 0, r = 0, i = 0;

        while (l < left_Size && r < right_Size) {
            if (left_Array[l].getWage() < right_Array[r].getWage()) {
                staffs[i] = left_Array[l];
                i++;
                l++;
            } else {
                staffs[i] = right_Array[r];
                i++;
                r++;
            }
        }
        while (l < left_Size) {
            staffs[i] = left_Array[l];
            i++;
            l++;
        }
        while (r < right_Size) {
            staffs[i] = right_Array[r];
            i++;
            r++;
        }
    }

    // Part 1 Question (3)
    public static void mergeSort_fName(Staff[] staffs) {
        if (staffs.length >= 2) {
            Staff[] left = new Staff[staffs.length / 2];
            Staff[] right = new Staff[staffs.length - left.length];

            for (int i = 0; i < left.length; i++) {
                left[i] = staffs[i];
            }
            for (int i = 0; i < right.length; i++) {
                right[i] = staffs[i + staffs.length / 2];
            }

            mergeSort_fName(left);
            mergeSort_fName(right);
            merge_fName(staffs, left, right);
        }
    }

    public static void merge_fName(Staff[] result, Staff[] left, Staff[] right) {
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length &&
                    left[i1].getFName().compareToIgnoreCase(right[i2].getFName()) < 0)) {
                result[i] = left[i1];
                i1++;
            } else {
                result[i] = right[i2];
                i2++;
            }
        }
    }

    // Part 1 Question (3)
    // Search from sorted Array with Alphabetical order (First name of the Staff)
    public static String binary_Search_fName(Staff[] sorted_Staffs, String query) {
        int upperB = sorted_Staffs.length;
        int lowerB = 0;

        while (lowerB <= upperB) {
            int mid = (upperB + lowerB) / 2;
            if (sorted_Staffs[mid].getFName().compareToIgnoreCase(query) == 0) {
                return "Staff info is found as follows \n" + sorted_Staffs[mid];
            } else if (sorted_Staffs[mid].getFName().compareToIgnoreCase(query) > 0) {
                upperB = mid - 1;
            } else {
                lowerB = mid + 1;
            }
        }
        return "Not an existing staff!";
    }

    // Part 1 Question (3)
    // Search from sorted Array with numerical order (Wage of the Staff)
    public static String binary_Search_wage(Staff[] staffs, Double query) {
        int upperB = staffs.length;
        int lowerB = 0;

        while (lowerB <= upperB) {
            int mid = (upperB + lowerB) / 2;
            if (staffs[mid].getWage() == query) {
                return staffs[mid].getEmpNo() + " " + staffs[mid].getFName() + " " + staffs[mid].getSName() + " " + staffs[mid].getDepartment() + " " + staffs[mid].getWage() + " " + staffs[mid].getProjectCompletionRate();
            } else if (staffs[mid].getWage() > query) {
                upperB = mid - 1;
            } else {
                lowerB = mid + 1;
            }
        }
        return "Not an existing wage!";
    }

    // Part 2 Question (1)
    public static void add_At_Last(Staff[] current_Staff) {
        // Create Scanner to get user's input
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter new member's info");

        System.out.print("First name: ");
        String fname = sc.next();

        System.out.print("Surname: ");
        String sName = sc.next();

        System.out.print("Department: ");
        String department = sc.next();

        System.out.print("Wage: ");
        float wage = sc.nextFloat();

        System.out.print("Project Completion Rate: ");
        float projectCompletionRate = sc.nextFloat();

        // Increase one from number of current staffs and the increased number will be used as index of newly added staff.
        int empNo = current_Staff.length + 1;

        // Create Instance to set each field of Staff class
        Staff addStaff = new Staff(empNo, fname, sName, department, wage, projectCompletionRate);
        System.out.println("New staff is successfully registered and registered info is as below" + "\n" +
                addStaff.toString());
    }

    // Part 2 Question (2)
    public static boolean firstName_Exception_Handling(String firstName) throws FirstName_Exception {
        Pattern letter = Pattern.compile("[a-zA-z]");
        Pattern mixed = Pattern.compile("^(?=.*[A-Z])(?=.*[0-9])[A-Z0-9]+$");
        Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");


        Matcher hasLetter = letter.matcher(firstName);
        Matcher hasMixed = mixed.matcher(firstName);
        Matcher hasSpecial = special.matcher(firstName);
        if ((hasLetter.find() || hasMixed.find()) && !hasSpecial.find() && !firstName.isBlank()) {
            return true;
        } else throw new FirstName_Exception(
                "Employee first_name cannot be empty. \n It cannot have only digits! \n Please correct this: " + firstName);
    }


    // Part 3 Question (1)
    public static String project_completion_In_Budget(Staff[] staffs, double budget) {
        mergeSort_Completion_Rate(staffs);
        String top_Employees = "";

        int index = staffs.length - 1;
        double sum_of_Wages = 0;

        for (; sum_of_Wages < budget; --index) {

            sum_of_Wages += staffs[index].getWage();

            if (sum_of_Wages < budget) {
                top_Employees += "[" + staffs[index].getFName() + " | " + staffs[index].getProjectCompletionRate() + "% | " + staffs[index].getWage() + "]" + "\n";
            }
        }

        return "Under Budget EUR: " + budget + ", Top Employees list is as following \n" + top_Employees;
    }


    // Part 3 Question (1)
    public static Staff[] mergeSort_Completion_Rate(Staff[] staffs) {
        int length = staffs.length;

        // Base case
        if (length <= 1) return staffs;
        int mid = length / 2;

        // Divide
        Staff[] left_Array = new Staff[mid];
        Staff[] right_Array = new Staff[length - mid];

        int l = 0, r = 0;

        for (; l < length; l++) {
            if (l < mid) {
                left_Array[l] = staffs[l];
            } else {
                right_Array[r] = staffs[l];
                r++;
            }
        }
        mergeSort_Completion_Rate(left_Array);
        mergeSort_Completion_Rate(right_Array);
        merge_Completion_Rate(left_Array, right_Array, staffs);
        return staffs;
    }

    // Part 3 Question (1)
    static void merge_Completion_Rate(Staff[] left_Array, Staff[] right_Array, Staff[] staffs) {
        int left_Size = staffs.length / 2;
        int right_Size = staffs.length - left_Size;
        int l = 0, r = 0, i = 0;

        while (l < left_Size && r < right_Size) {
            if (left_Array[l].getProjectCompletionRate() < right_Array[r].getProjectCompletionRate()) {
                staffs[i] = left_Array[l];
                i++;
                l++;
            } else {
                staffs[i] = right_Array[r];
                i++;
                r++;
            }
        }
        while (l < left_Size) {
            staffs[i] = left_Array[l];
            i++;
            l++;
        }
        while (r < right_Size) {
            staffs[i] = right_Array[r];
            i++;
            r++;
        }
    }
}

class Staff implements Comparable<Object> {

    private int empNo;
    private String fName;
    private String sName;
    private String department;
    private float wage;
    private float projectCompletionRate;


    // constructor
    public Staff(int empNo, String fName, String sName, String department, float wage, float projectCompletionRate) {
        super();
        this.empNo = empNo;
        this.fName = fName;
        this.sName = sName;
        this.department = department;
        this.wage = wage;
        this.projectCompletionRate = projectCompletionRate;
    }

    // setters and getters
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getProjectCompletionRate() {
        return projectCompletionRate;
    }

    public void setProjectCompletionRate(float projectCompletionRate) {
        this.projectCompletionRate = projectCompletionRate;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }

    // so the film objects can be compared when sorting/searching
    // NOTE: this will only allow comparisons based on the title of the film
    @Override
    public int compareTo(Object obj) {

		/*
		Edit this section so it compares the appropriate
		column you wish to sort by
		*/

        Staff sff = (Staff) obj;
        return empNo - (sff.getEmpNo());
    }

    @Override
    public String toString() {
        return "Staff [EmpNo=" + empNo + ", first name=" + fName + ", last Name=" + sName + ", department="
                + department + ", wage=" + wage + ", project completion rate="
                + projectCompletionRate + "]";
    }
}