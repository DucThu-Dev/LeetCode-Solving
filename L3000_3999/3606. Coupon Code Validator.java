
import java.util.ArrayList;
import java.util.List;

class Coupon {

    public String code;
    public String businessLine;

    public Coupon(String code, String businessLine) {
        this.code = code;
        this.businessLine = businessLine;
    }
}

class Solution {

    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        List<String> validBusiness = List.of("electronics", "grocery", "pharmacy", "restaurant");
        List<Coupon> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!isActive[i]) {
                continue;
            }

            if (code.length > 0 && !code[i].matches("^[a-zA-z0-9_]+$")) {
                continue;
            }

            if (!validBusiness.contains(businessLine[i])) {
                continue;
            };

            Coupon coupon = new Coupon(code[i], businessLine[i]);
            list.add(coupon);
        }

        list.sort((a, b) -> {
            if (!a.businessLine.equals(b.businessLine)) {
                return a.businessLine.compareTo(b.businessLine);
            }

            return a.code.compareTo(b.code);
        });

        return list.stream().map((a) -> {
            return a.code;
        }).toList();
    }
}
