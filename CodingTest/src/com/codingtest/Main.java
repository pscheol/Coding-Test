package com.codingtest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        String s = in.readLine();
        String[] str = s.split(" ");
        int[] n = new int[t];
        for (int i = 0; i<str.length; i++) {
            n[i] = Integer.parseInt(str[i]);
        }
        newYearChaos(n);
    //    out.write("" + longestNumber(t,n));
        out.write("\n");
        out.flush();
        out.close();
        in.close();
    }

    public static void newYearChaos(int[] q) {
        int bribe = 0;

        //뇌물은 최대 두 번 2이상 차이나면 chaotic 리턴
        for (int i = 0; i < q.length; i++) {
            if((q[i] - (i + 1)) > 2) {
                System.out.println("Too chaotic");
                return;
            }
        }

        for(int i = 0 ; i < q.length ; i ++) {
            for(int j = q[i] - 2; j < i; j++) {
                if (j >= 0 && q[j] > q[i]) {
                    bribe++;
                }

            }
        }
        System.out.println(bribe);
    }

   /* static long longestNumber(int t, int[] n) {
        int[] dp = new int[t];
        int[] val = new int[t];
        for (int i = 0; i < t; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (n[i] > n[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    val[i] = n[dp[i]];
                }
            }
        }
        int ret = dp[0];
        for (int i =0; i<dp.length; i++) {
            if (ret < dp[i]) {
                ret = dp[i];

            }
            System.out.println(val[i]);
        }

        return ret;
    }
    static long pinaryNumber(int n) {
        long[] result = new long[90];
        result[0] = result[1] = 1;
        for (int i = 2; i < result.length; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        return result[n-1];
    }
    static int sockMerchant(int n, int[] ar) {
        int[] dp = new int [101];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[ar[i]]++;
        }
        for (int i = 1; i <= 100; i++) {
            ans += dp[i] /2;
        }
        return ans;
    }
    public static long easyStair(int n) {
        long mod = 1000000000L;
        long[][] dp = new long[n + 1][10];
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                dp[i][j] = 0;
                if (j - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                if (j + 1 <= 9) {
                    dp[i][j] += dp[i - 1][j + 1];
                }
                dp[i][j] %= mod;
            }
        }
        long solv = 0;
        for (int i = 0; i <=9; i++) {
            solv += dp[n][i];
        }
        return solv %= mod;
    }

    public static int cardBuy(int[] p, int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + p[j]);
            }
        }
        return dp[n];
    }

    public static int cardBuy2(int[] p, int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = -1;
            for (int j = 1; j <= i; j++) {
                if (dp[i] == -1 || dp[i] > dp[i - j] + p[j]) {
                    dp[i] = dp[i - j] + p[j];
                }
            }
        }
        return dp[n];
    }

    public static int plus123(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 3 && i - j >= 0; j++) {
                dp[i] += dp[i - j];
            }
        }
        return dp[n];
    }

    public static int tileOf2xn2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + (2 * dp[i - 2])) % 10007;
        }
        return dp[n];
    }

    public static int tileOf2xn(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }
        return dp[n];
    }


    public static int makeItOne(int n) {
        int[] table = new int[n + 1];
        table[1] = 0;
        for (int i = 2; i <= n; i++) {
            table[i] = table[i - 1] + 1;
            if (i % 2 == 0 && table[i] > table[i / 2] + 1) {
                table[i] = table[n / 2] + 1;
            } else if (i % 3 == 0 && table[i] > table[i / 3] + 1) {
                table[i] = table[n / 3] + 1;
            }
        }
        return table[n];
    }*/
}

    /*public static void g2() throws Exception {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        String[] split = str.split(" ");
        int n = Integer.parseInt(split[0]);
        int s = Integer.parseInt(split[1]);

        String str2 = in.readLine();
        String[] split2 = str2.split(" ");
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(split2[i]);
            a[i] = Math.abs(x-s);
            System.out.println("Math.abs(x-s) : " + Math.abs(x-s));
        }

        int result = a[0];
        for (int i = 1; i < n; i++) {
            result = gcd(result, a[i]);
        }

        out.write(result + "\n");
        out.flush();;
        out.close();
        in.close();
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }*/

 /*   public static void sumOfGCD() throws Exception {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        while (t-- != 0) {
            String s = in.readLine();
            String[] split = s.split(" ");
            int n = Integer.parseInt(split[0]);
            long sum = 0;
            for (int i = 1; i <= n - 1; i++) {
                for (int j = i + 1; j <= n; j++) {
                    sum += gcd(Integer.parseInt(split[i]), Integer.parseInt(split[j]));
                }
            }
            out.write(sum + "\n");
            out.flush();
        }
        out.close();
        in.close();
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }*/

    /*public static void goldbachsConjecture() throws Exception {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int length = 1000000;
        boolean[] check = new boolean[length + 1];
        check[0] = check[1] = true;
        for (int i = 2; i <= length; i++) {
            if (!check[i])
                for (int j = i + i; j <= length; j += i) check[j] = true;
        }

        int n = 0;
        int a;
        boolean flags;
        while ((n = Integer.parseInt(in.readLine())) != 0) {
            a = 2;
            flags = false;
            for (int i = a; i < n; i++) {
                if (!check[i] && (!check[i] && !check[n - i])) {
                    out.write(n + " = " + i + " + " + (n - i) + "\n");
                    flags = true;
                    break;
                }
            }
            if (!flags) out.write("Goldbach's conjecture is wrong.");
            out.flush();
        }


        out.close();
        in.close();
    }*/

    /*public static void prime() throws Exception {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        String[] split = str.split(" ");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);

        int[] num = new int[n + 1];
        boolean[] check = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            num[i] = i;
        }
        check[0] = check[1] = true;
        for (int i = 2; i <=n; i++) {
            if (!check[i])
                for (int j = i + i; j <= n; j+=i) check[j] = true;
        }

        for (int i = m; i <=n; i++) {
            if (!check[i])
                out.write(num[i] + "\n");
        }
        out.flush();
        out.close();
        in.close();
    }*/

    /*public static void gcdAndlcm() throws Exception {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        String[] split = str.split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int gcd = gcd(a, b);
        out.write(gcd + "\n");
        out.write(lcm(a, b, gcd) + "\n");
        out.flush();
        out.close();
        ;
        in.close();
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int lcm(int a, int b, int gcd) {
        return (a * b) / gcd;
    }*/

  /*  public static void suffixOfArray() throws Exception {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        String[] arr = new String[str.length()];

        for (int i = 0; i<str.length(); i++) {
            arr[i] = str.substring(i);
        }
        Arrays.sort(arr);
        for (String s : arr) {
            out.write(s+'\n');
        }
        out.flush();
        out.close();;
        in.close();
    }*/

    /*public static void solve() throws Exception {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        String[] split = str.split(" ");
        long num1 = Long.parseLong(split[0] + split[1]);
        long num2 = Long.parseLong(split[2] + split[3]);
        out.write(num1+num2+"\n");
        out.flush();
        out.close();;
        in.close();
    }
    public static void solve2() throws Exception {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        String[] split = str.split(" ");
        long num1 = parseLong(split[0] + split[1]);
        long num2 = parseLong(split[2] + split[3]);
        out.write(num1+num2+"\n");
        out.flush();
        out.close();;
        in.close();
    }
    public static long parseLong(String str) {
        char[]  chs = str.toCharArray();
        int length = chs.length;
        long exp = 1;
        long result = 0;

        int i = length -1;
        while (i != -1) {
            result += (chs[i--] - '0') * exp;
            exp *= 10;
        }
        return result;
    }*/


    /*public static void rot13() throws Exception {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                out.write(rot('a', ch, 13));
            } else if (ch >= 'A' && ch <= 'Z') {
                out.write(rot('A', ch, 13));
            } else {
                out.write(ch);
            }
        }
        out.flush();
        out.close();
        in.close();
    }

    private static char rot(char ascii, char ch, int rotNum) {
        return (char) (ascii + ((ch - ascii) + rotNum) % 26);
    }*/


    /*public static void alphabetFound() throws Exception {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        char[] chars = str.toCharArray();
        int[] result = new int [26];
        Arrays.fill(result, -1);

        for (int i = 0; i < chars.length; i++) {
            int idx = chars[i] - 'a';
            if (result[idx] == -1)
                result[idx] = i;
        }

        for(int i : result) {
            out.write(i + " ");
        }
        out.flush();
        out.close();
        in.close();

    }*/

    /*public static void alphabetCount() throws Exception {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        int[] result = new int [26];
        for (char ch : str.toCharArray()) {
            result[ch - 'a']++;
        }

        for(int i : result) {
            out.write(i + " ");
        }
        out.flush();
        out.close();
        in.close();

    }*/
    /*public static void convertToPostfix() throws Exception {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String infix = in.readLine();

        Stack<Character> stack = new Stack<>();
        for (char ch : infix.toCharArray()) {
            switch (ch) {
                case '+':case '-':case '*':case '/':
                    //스택에 있는 연산자가 우선순위가 더 크거나 같으면 출력
                    while(!stack.isEmpty() && prec(stack.peek()) >= prec(ch))
                        out.write(stack.pop());
                    stack.push(ch);
                    break;
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    char op = stack.pop();
                    //왼쪽괄호를 만날 때까지 계속 출력
                    while (op != '(') {
                        out.write(op);
                        op = stack.pop();
                    }
                    break;
                default: //A~Z
                    out.write(ch);
                    break;
            }
        }
        while(!stack.isEmpty()) {
            out.write(stack.pop());
        }
        out.flush();
        out.close();
        in.close();
        ;
    }

    public static int prec(char op) {
        switch (op) {
            case '(': case ')': return 0;
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            default: return -1;
        }
    }*/

    /*public static void postfixNotation() throws Exception {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        String postfix = in.readLine();
        double[] numbers = new double[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Double.parseDouble(in.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for (char ch : postfix.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                stack.push(numbers[(ch - 'A')]);
            } else {
                double n2 = stack.pop();
                double n1 = stack.pop();
                switch (ch) {

                    case '+':
                        stack.push(n1 + n2);
                        break;
                    case '-':
                        stack.push(n1 - n2);
                        break;
                    case '*':
                        stack.push(n1 * n2);
                        break;
                    case '/':
                        stack.push(n1 / n2);
                        break;
                }
            }
        }
        out.write(String.format("%.2f\n", stack.pop()));
        out.flush();
        ;
        out.close();
        in.close();
    }*/

    /*public static void bigNumber() throws Exception {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(in.readLine());

        String s = in.readLine();


        String[] A = s.split(" ");
        if (n != A.length) {
            return;
        }

        int[] NGE = new int[n];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        for (int i = 1; i < n; i++) {
            int a = Integer.parseInt(A[i]);
            while (!stack.isEmpty() && Integer.parseInt(A[stack.peek()]) < a) {
                NGE[stack.pop()] = a;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            NGE[stack.pop()] = -1;
        }

        for (int ans : NGE) {
            out.write(ans + " ");
        }
        out.write("\n");
        out.flush();
        out.close();
        in.close();
    }*/

    /*public static void ironBar() throws Exception {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s = in.readLine();
        int result = 0;
        char before = ' ';
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    stack.pop();
                    result += (before == ')') ? 1 : stack.size();
                    break;
            }
            before = ch;
        }
        out.write(result + "\n");
        out.flush();
        out.close();
        ;
        in.close();
    }*/


    /*public static void replace() throws Exception {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s = in.readLine();

        boolean tag = false;
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '<':
                    print(out, stack);
                    out.write(ch);
                    tag = true; // 괄호시작
                    break;
                case '>':
                    out.write(ch);
                    tag = false; //괄호 종료
                    break;
                default:
                    if (tag) {
                        out.write(ch);
                    } else if (ch == ' ') {
                        print(out, stack);
                        out.write(ch);
                    } else {
                        stack.push(ch);
                    }
                    break;
            }
        }
        print(out, stack);
        out.write('\n');
        out.flush();
        ;
        out.close();
        in.close();
        ;
    }

    public static void print(BufferedWriter out, Stack<Character> stack) throws Exception {
        while (!stack.isEmpty()) {
            out.write(stack.pop());
        }
    }*/


    /*public static void josephus() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = in.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <=n; i++) {
            queue.offer(i);
        }
        int cnt = 1;
        StringBuilder sb = new StringBuilder("<");
        while (!queue.isEmpty()) {
            if (k == cnt) {
                cnt = 1;
                sb.append(queue.poll());
                if (!queue.isEmpty()) {
                    sb.append(", ");
                }
            } else {
                cnt++;
                queue.offer(queue.poll());
            }
        }
        sb.append(">");
        out.write(""+ sb.toString());
        out.flush();
        ;
        out.close();
        ;
        in.close();
    }*/
    /*
    public static void editor() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));


        String read = in.readLine();
        if (read.length() > 100000) {
            return;
        }
        int m = Integer.parseInt(in.readLine());

        if (m < 1 || m > 500000) {
            return;
        }

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (char ch : read.toCharArray())
            left.push(ch);

        for (int i = 0; i < m; i++) {
            String input = in.readLine();
            switch (input.charAt(0)) {
                case 'L':
                    if (!left.isEmpty())
                        right.push(left.pop());
                    break;
                case 'D':
                    if (!right.isEmpty())
                        left.push(right.pop());
                    break;
                case 'B':
                    if (!left.isEmpty())
                        left.pop();
                    break;
                case 'P':
                    left.push(input.charAt(2));
                    break;

            }
        }

        while (!left.isEmpty()) {
            right.push(left.pop());
        }
        while (!right.isEmpty()) {
            out.write("" + right.pop());
        }
        out.flush();

        out.close();
        in.close();
    }
*/

  /*  public static void editorLinkedList() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));


        String read = in.readLine();
        if (read.length() > 100000) {
            return;
        }
        int m = Integer.parseInt(in.readLine());

        if (m < 1 || m > 500000) {
            return;
        }

        List<Character> list = new LinkedList<>();
        for (char ch : read.toCharArray())
            list.add(ch);

        int idx = list.size();
        for (int i = 0; i < m; i++) {
            String input = in.readLine();
            char[] chs = input.toCharArray();
            switch (chs[0]) {
                case 'L':
                    idx = (idx == 0) ? 0 : --idx;
                    break;
                case 'D':
                    idx = (idx == list.size()) ? idx : ++idx;
                    break;
                case 'B':
                    if (idx != 0)
                        list.remove(idx- 1);
                    idx = (idx == 0) ? 0 : --idx;
                    break;
                case 'P':
                    list.add(idx++, chs[2]);
                    break;
            }
        }

        for (char ch : list) {
            out.write(ch + "");
        }

        out.flush();

        out.close();
        in.close();
    }*/

/*

    public static void stackSequence() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(in.readLine());
        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(in.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int m = 0;
        for (int data : seq) {
            if (m < data) {
                while (m < data) {
                    stack.push(++m);
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if (stack.peek() != data) {
                    System.out.println("NO");
                    return;
                }
                stack.pop();
                sb.append("-\n");
            }
        }

        out.write(sb.toString());
        out.flush();
        out.close();
        in.close();
    }
}
*/

/*
    public static void parenthesis() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));


        int t = parseInt(in.readLine());
        while (0 < t--) {
            Stack<Character> stack = new Stack<>();
            String ps = in.readLine();
            String result = "YES";
            for (int i = 0; i <ps.length(); i++) {
                char ch = ps.charAt(i);
                if (ch == '(') {
                    stack.push(ch);
                    continue;
                }
                if (stack.empty()) {
                    result = "NO";
                    break;
                }
                stack.pop();
            }
            if (result.equals("YES") && !stack.empty()) {
                result = "NO";
            }
            out.write(result);
            out.write('\n');
            out.flush();;
        }
        out.close();
        in.close();
    }

    public static void flipWord() throws Exception {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = parseInt(in.readLine());

        while (0 < t--) {
            Stack<Character> stack = new Stack<>();
            String word = in.readLine() + "\n";
            for (int i  = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (ch != ' ' && ch != '\n') {
                    stack.push(ch);
                    continue;
                }
                while(!stack.isEmpty()) {
                    out.write(stack.pop());
                }
                out.write(ch);
            }
            out.flush();
        }
        out.close();;
        in.close();;
    }

    public static void stack() throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = parseInt(in.readLine());
        String stack[] = new String[n];
        int size = -1;

        for (int i = 1; i <= n; i++) {
            String input = in.readLine();
            if (input.contains("push")) {
                stack[++size] = input.split(" ")[1];
            } else if (input.equals("pop")) {
                out.write(size == -1 ? size + "\n" : stack[size--] + "\n");
            } else if (input.equals("size")) {
                out.write((size + 1) + "\n");
            } else if (input.equals("empty")) {
                out.write((size == -1 ? 1 : 0) + "\n");
            } else if (input.equals("top")) {
                out.write((size == -1 ? size : stack[size]) + "\n");
            }
            out.flush();
        }
        in.close();
        out.close();
    }

    public static int parseInt(String arg) {
        return Integer.parseInt(arg);
    }
}*/
