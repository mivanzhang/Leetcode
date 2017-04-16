import java.util.Arrays;
import java.util.List;

public class Main {
    private static int allZeroCout = 0;
    private static int allOneCout = 0;

    public static void main(String[] args) {
        System.out.println("findMaxForm1 return value is " + findMaxForm1());
        System.out.println("Hello World!");
        Main main = new Main();
        String[] strs = {"10", "0001", "111001", "1", "0"};
//        String[] strs = {"1", "0"};
        int m = 1;
        int n = 1;
        System.out.println(" max size is   " + main.findMaxForm(strs, m, n));
    }

    public static int findMaxForm1() {
        try {
            int x = 1 / 0;
        } catch (Exception e) {
            return 1;
        } finally {
            return 2;
        }
    }


    public int findMaxForm(String[] strs, int m, int n) {
        if (null == strs) {
            return 0;
        }
        allZeroCout = m;
        allOneCout = n;
        Bintray[] bintrays = getBintray(strs);
        int max = 0;
        for (Bintray bintray : bintrays) {
            System.out.println(bintray.max);
            int maxcount = caculateNumber(bintrays, bintray.couple);
            if (maxcount > max) {
                max = maxcount;
            }
        }
        return max;
    }

    private int caculateNumber(Bintray[] bintrays, Couple couple) {
        if (bintrays.length == 1) {
            if (bintrays[0].isAvaliable(couple)) {
                return 1;
            } else {
                return 0;
            }
        }
        Bintray lastBintray = bintrays[bintrays.length - 1];
        lastBintray.max += caculateNumber(Arrays.copyOf(bintrays, bintrays.length - 1), lastBintray.couple);
        return lastBintray.max;
    }


    private Couple caculateZeroNumber(Bintray[] bintrays, int count, int maxCount) {

        if (bintrays.length == 1) {
            return bintrays[0].multiple(count);
        }
        Bintray lastBintray = bintrays[bintrays.length];
        lastBintray.multiple(count);

        Couple yesCouple = caculateZeroNumber(Arrays.copyOf(bintrays, bintrays.length - 1), 1, maxCount);
        Couple noCouple = caculateZeroNumber(Arrays.copyOf(bintrays, bintrays.length - 1), 0, maxCount);
        if (lastBintray.isAvaliable(yesCouple)) {
            maxCount++;
            lastBintray.couple.add(yesCouple);
        } else if (lastBintray.isAvaliable(noCouple)) {
            lastBintray.couple.add(noCouple);
        }
        lastBintray.couple.max = maxCount;
        return lastBintray.couple;

    }


    public Bintray[] getBintray(String[] strs) {
        Bintray[] bintrayArray = new Bintray[strs.length];
        for (int i = 0; i < strs.length; i++) {
            bintrayArray[i] = new Bintray(strs[i]);
            System.out.println(strs[i] + " bintrayArray  o number " + bintrayArray[i].caculateZeroNumber());
            System.out.println(strs[i] + " bintrayArray  1 number " + bintrayArray[i].caculateOneNumber());
        }
        return bintrayArray;
    }


    class Bintray {
        Couple couple = new Couple();
        public String originString;
        int max = 0;

        public Bintray(String originString) {
            if (originString == null) {
                this.originString = "";
            } else {
                this.originString = originString;
            }
            couple.zeroCount = caculateZeroNumber();
            couple.oneCount = caculateOneNumber();
        }

        private int caculateZeroNumber() {
            int count = 0;
            for (int i = 0; i < originString.length(); i++) {
                if ("0".equals(String.valueOf(originString.charAt(i)))) {
                    count++;
                }
            }
            return count;
        }

        private int caculateOneNumber() {
            return originString.length() - couple.zeroCount;
        }

        public Couple multiple(int ply) {
            return couple.multiple(ply);
        }

        public boolean isAvaliable(Couple couple1) {
            if ((couple.zeroCount + couple1.zeroCount <= allZeroCout) && (couple.oneCount + couple1.oneCount <= allOneCout))
                return true;
            return false;
        }

    }

    class Couple {
        int zeroCount = 0;
        int oneCount = 0;
        int max = 0;
        Couple nextCouples;

        public Couple add(Couple couple) {
            zeroCount += couple.zeroCount;
            oneCount += couple.oneCount;
            return this;
        }

        public Couple multiple(int ply) {
            zeroCount *= ply;
            oneCount *= ply;
            return this;
        }

    }

}
