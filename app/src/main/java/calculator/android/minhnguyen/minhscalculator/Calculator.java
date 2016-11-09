package calculator.android.minhnguyen.minhscalculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Calculator extends AppCompatActivity {

    String input = "", result = "0";
    String inputm = "", math = "";
    double del, tt, mid;
    double cal1, cal2, calmid;
    int count_prd, count_bk_open, count_bk_close, mid_math;
    boolean math_press = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
        Button btnPeriod, btnEqual, btnAC, btnOpen, btnClose, btnDel, btnDivision, btnMulti, btnMinus, btnPlus;

        //gán id cho biến button mới khai báo
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);

        btnPeriod = (Button) findViewById(R.id.btnPeriod);
        btnEqual = (Button) findViewById(R.id.btnEqual);
        btnAC = (Button) findViewById(R.id.btnAC);
        btnOpen = (Button) findViewById(R.id.btnOpen);
        btnClose = (Button) findViewById(R.id.btnClose);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnDivision = (Button) findViewById(R.id.btnDivision);
        btnMulti = (Button) findViewById(R.id.btnMulti);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnPlus = (Button) findViewById(R.id.btnPlus);

        //bắt sự kiện cho từng button
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result = "0";
                input = inputm = math = "";
                cal1 = cal2 = calmid = 0;
                count_prd = count_bk_open = count_bk_close = mid_math = 0;
                math_press = false;
                showInput(input);
                showResult(result);
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input != "") {
                    del = Double.parseDouble(input);
                    tt = (del - del % 10) / 10;
                    DecimalFormat dfinp = new DecimalFormat("#.#");
                    if (tt != 0)
                        input = dfinp.format(tt);
                    else {
                        input = "";
                        showResult("0");
                    }
                } else {
                    input = "";
                }
                showInput(inputm + input);
                count_prd = 0;
            }
        });

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputm = inputm + "(";
                showInput(inputm);
                count_bk_open++;
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = input + ")";
                showInput(inputm);
                count_bk_close++;
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                math = "plus";
                math_press = true;
                MathPress();
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                math = "minus";
                math_press = true;
                MathPress();
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                math = "multi";
                math_press = true;
                MathPress();
            }
        });

        btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                math = "divi";
                math_press = true;
                MathPress();
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input != "") {
                    if (math == "") {
                        result = input;
                        if (Double.parseDouble(input) % 1 == 0) cal1 = Integer.parseInt(input);
                        else cal1 = Double.parseDouble(input);
                    } else {
                        if (calmid % 1 == 0) result = String.valueOf((int) calmid);
                        else result = String.valueOf(calmid);
                    }
                    showResult(result);
                }
                calmid = cal1;
                inputm = result;
                math = input = "";
                showInput("");
                count_prd = mid_math = 0;
                mid = 0;
                math_press = false;
            }
        });

        btnPeriod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count_prd == 0) {
                    if (input == "")
                        input = "0.";
                    else
                        input = input + ".";
                    if (math_press) showInput(inputm + input);
                    else {
                        showInput(input);
                    }
                    count_prd = 1;
                }
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumPress("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumPress("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumPress("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumPress("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumPress("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumPress("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumPress("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumPress("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumPress("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumPress("9");
            }
        });
    }

    //hiện chuỗi ở TextView input
    void showInput(String inp) {
        TextView tvInput;
        tvInput = (TextView) findViewById(R.id.tvInput);
        tvInput.setText(inp);
    }

    //hiện chuỗi ở TextView result
    void showResult(String rs) {
        TextView tvResult;
        tvResult = (TextView) findViewById(R.id.tvResult);
        tvResult.setText(rs);
        //đổi màu khi phép tính sai
        if (tvResult.getText() == "Math ERROR!")
            tvResult.setTextColor(Color.RED);
        else
            tvResult.setTextColor(Color.WHITE);
        //đổi font size khi kết quả quá dài
        if (tvResult.getLineCount() > 1)
            tvResult.setTextSize(40);
        else tvResult.setTextSize(64);
    }

    //Sự kiện khi nhấn phím số
    void NumPress(String outp) {
        input = input + outp;
        if (math_press = true) showInput(inputm + input);
        else {
            showInput(input);
            inputm = "";
            calmid = 0;
            cal1 = 0;
        }
        CheckIntDouble(input);
        switch (math) {
            case "plus":
                calmid = cal1 + cal2;
                break;
            case "minus":
                calmid = cal1 - cal2;
                break;
            case "multi":
                if (mid_math == 1) {
                    cal1 = cal1 - mid;
                    cal2 = mid * cal2;
                    calmid = cal1 + cal2;
                } else if (mid_math == 2) {
                    cal1 = cal1 + mid;
                    cal2 = mid * cal2;
                    calmid = cal1 - cal2;
                } else calmid = cal1 * cal2;
                break;
            case "divi":
                if (cal2 != 0) {
                    if (mid_math == 1) {
                        cal1 = cal1 - mid;
                        cal2 = mid / cal2;
                        calmid = cal1 + cal2;
                    } else if (mid_math == 2) {
                        cal1 = cal1 + mid;
                        cal2 = mid / cal2;
                        calmid = cal1 - cal2;
                    } else calmid = cal1 / cal2;
                    if (calmid % 1 == 0) showResult(String.valueOf((int) calmid));
                    else showResult(String.valueOf(calmid));
                } else showResult("Math ERROR!");
                break;
            default:
                break;
        }
        if (math != "divi") {
            if (calmid % 1 == 0) showResult(String.valueOf((int) calmid));
            else showResult(String.valueOf(calmid));
        }
    }

    //Sự kiện khi nhấn phím phép tính
    void MathPress() {
        if (input != "") {
            if (result == "0") {
                if (Double.parseDouble(input) % 1 == 0) {
                    if (calmid == 0) cal1 = Integer.parseInt(input);
                    else cal1 = calmid;
                } else {
                    if (calmid == 0) cal1 = Double.parseDouble(input);
                    else cal1 = calmid;
                }
            } else cal1 = Double.parseDouble(result);
            switch (math) {
                case "plus":
                    inputm = inputm + input + "\u002B";
                    mid_math = 1;
                    break;
                case "minus":
                    inputm = inputm + input + "\u2212";
                    mid_math = 2;
                    break;
                case "multi":
                    inputm = inputm + input + "\u00D7";
                    mid = cal2;
                    break;
                case "divi":
                    inputm = inputm + input + "\u00F7";
                    mid = cal2;
                    break;
                default:
                    break;
            }
            showInput(inputm);
            input = "";
            count_prd = 0;
        }
    }

    void CheckIntDouble(String cid) {
        if (Double.parseDouble(input) % 1 == 0) cal2 = Integer.parseInt(input);
        else cal2 = Double.parseDouble(input);
    }
}