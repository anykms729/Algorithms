import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        String[] countries = {"Afghanistan", "Albania", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji", "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Finland", "France", "France Metropolitan", "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Zambia", "Zimbabwe", "Palestine"};
        mergeSortStrings(countries, 0, countries.length);

    }

    private static int sum(int number) {
        int result;
        // Base case
        if (number < 0) return -1;
        else if (number == 1) return 1;
        else {
            result = sum(number - 1) + number;
        }
        return result;
    }

    public int linearSearch(int[] integers, int searchKey) {
        int isFound = -1;
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] == searchKey) {
                isFound = i;
            }
        }
        return isFound;
    }

    public int binarySearch(int[] integers, int searchKey) {
        int isFound = -1;

        int lower_Index = 0;
        int higher_Index = integers.length;

        while (lower_Index <= higher_Index) {
            int mid = (lower_Index + higher_Index) / 2;

            if (integers[mid] == searchKey) {
                isFound = mid;
                break;
            } else if (searchKey > integers[mid]) {
                lower_Index = mid + 1;
            } else {
                higher_Index = mid - 1;
            }
        }
        return isFound;
    }

    public String linearSearch(String[] countries, String searchKey) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i] == searchKey) {
                return countries[i];
            }
        }
        return String.valueOf(-1);
    }

    public static void mergeSortStrings(String[] countries, int lowerB, int upperB) {

        if (lowerB < upperB - 1) {
            int mid = (lowerB + upperB) / 2;
            System.out.println("lowerB: "+lowerB+ " mid: "+mid+ " upperB: "+upperB);
            mergeSortStrings(countries, lowerB, mid);
            mergeSortStrings(countries, mid, upperB);
            merge(countries, lowerB, mid, upperB);
        }
    }

    private static void merge(String[] countries, int lowerB, int mid, int upperB) {
        int low = lowerB;
        int m = mid;
        String temp[] = new String[upperB - lowerB];
        int index = 0;

        while (low < mid && m < upperB) {
            if (countries[low].compareToIgnoreCase(countries[m]) < 0) {
                temp[index] = countries[low];
                index++;
                low++;
            } else {
                temp[index] = countries[m];
                index++;
                m++;
            }
        }
        while (low < mid) {
            temp[index] = countries[low];
            index++;
            low++;
        }

        while (m < upperB) {
            temp[index] = countries[m];
            index++;
            m++;
        }

        low = lowerB;
        index = 0;
        while (index < temp.length) {
            countries[low] = temp[index];
            low++;
            index++;
        }
    }

    public static String binarySearch(String[] countries, String searchKey) {
        mergeSortStrings(countries, 0, countries.length);
        String country_Found = "country not found message";

        int lower_Index = 0;
        int higher_Index = countries.length - 1;

        while (lower_Index <= higher_Index) {
            int mid = (lower_Index + higher_Index + 1) / 2;
            if (countries[mid] == searchKey) {
                country_Found = countries[mid];
                return country_Found;
            } else if (searchKey.compareToIgnoreCase(countries[mid]) > 0) {
                lower_Index = mid + 1;
            } else {
                higher_Index = mid - 1;
            }
        }
        return country_Found;
    }
}
