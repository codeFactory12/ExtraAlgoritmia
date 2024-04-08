package com.FuzzyMatching.RecomendSeriesByGenre.ProcessRabinKarp;

public class RabinKarp {
    private static final int prime = 101;
    private static boolean search(String pat, String txt) {
        boolean find = false;
        int m = pat.length();
        int n = txt.length();
        int patHash = 0;
        int txtHash = 0;
        int h = 1;

            for (int i = 0; i < m - 1; i++){
                h = (h * prime) % prime;
            }

            for (int i = 0; i < m; i++) {
                patHash = (prime * patHash + pat.charAt(i)) % prime;
                txtHash = (prime * txtHash + txt.charAt(i)) % prime;
            }

            for (int i = 0; i <= n - m; i++) {
                if (patHash == txtHash) {
                    boolean flag = true;
                    for (int j = 0; j < m; j++) {
                        if (txt.charAt(i + j) != pat.charAt(j)) {
                            flag = false;
                            break;
                        }
                    }

                    if (flag){
                        find= true;
                        break;
                    }

                }

                if (i < n - m) {
                    txtHash = (prime * (txtHash - txt.charAt(i) * h) + txt.charAt(i + m)) % prime;
                    if (txtHash < 0){
                        txtHash = (txtHash + prime);
                    }
                }

        }
        return find;
    }

    public static boolean rabinExact (String pat, String text, boolean exactMatch){
        boolean res = false;
        int m = pat.length();
        int n = text.length();

        if(exactMatch){
            if(m == n){
                res = search(pat,text);
            }
        }else{
            if(m < n){
                res = search(pat,text);
            }
        }

        return res;
    }
}

