Project: Fractional Calculator


Introduction {.western}
============

The objective of this assignment is to create a calculator to compute
arithmetic operations between integers and/or fractions and output the
result as a reduced mixed fraction.

\

Specifications {.western}
==============

Input {.western}
-----

Input will be in the form of a value, followed by an arithmetic
operator, and then another value. Values and operators will be separated
by a single space. Values will contain no spaces.

\

Input values may be in the form of mixed fractions, proper fractions,
improper fractions or integers. The integer and fraction parts of a
mixed fraction will be separated by an underscore (\_) (e.g., “1\_3/4”
is one and three fourths to distinguish it from “13/4” which is thirteen
fourths).

\

The calculator will support the 4 basic arithmetic operations: add (+),
subtract (-), multiply (\*), and divide (/).

\

The program should accept an equation, calculate the result in the
proper form, print it to screen, and then be ready to accept another
equation. The user should be able to exit the program by entering the
command “quit" instead of an equation.

\

*See the examples section below for clarification.*

\

Output {.western}
------

The output value must always be reduced and never improper (it may be an
integer, fraction, or mixed fraction, as appropriate). Example: a result
of 10/4 should be printed to the screen as 2\_1/2).

**Input**

**Output**

**Notes**

**1/4 + 1\_1/2**

1\_3/4

\

**8/4 + 2**

4

Input may be an improper fraction.

**-1 \* -1/2**

1/2

\

**-11/17 + -1/17**

-12/17

\

**0 \* 25\_462/543**

0

Remember to check for border/special cases.

\

*See the examples section below for clarification.*

\

Examples {.western}
========

\

\

\

\

\

\

\

\

\

Use the included unit tests (described below) to thoroughly check your
program, well beyond the above examples. We use these same tests to
grade your project.

Code Organization {.western}
=================

You must organize your code in the following way to receive credit for
your project. If you deviate from this, your unit tests will fail, and
significant points will be deducted from your grade.

\

1.  You must complete the implementation for the following method,
    inside your FracCalc.java file:

\

public static String produceAnswer(String input)

\

This method receives a single line of user input as its parameter (for
example, “3\_1/2 + 1/4"), and returns the answer (for example,
“3\_3/4”). *This method does not print anything*!

\

\

2.  Your main() method must use a Scanner to receive input from the
    user, call *produceAnswer* with that input, and then print the
    answer that was returned by *produceAnswer*. Your main method
    eventually is responsible for *repeatedly* reading input from the
    user, calling produceAnswer(), printing the result, and ending once
    the user types “quit”, although in the first checkpoint only one
    line of input needs to be read, with a single response printed to
    the console.

\

\

3.  **Your code must pass the unit tests** for the checkpoint you’re
    submitting. If all the tests fail, that is a sign your code is
    organized incorrectly. Fix before submitting to us.

\

Comments {.western}
========

-   You will not need to worry about integer overflows for this
    assignment.

\

-   Use the unit tests! You control your destiny by ensuring your grade
    before you submit to us.

\

-   The topics we have been learning in class are designed to allow you
    to complete this assignment. Remember to review your notes and the
    textbook.

    -   Scanner, indexOf, substring, etc.

\

\
\

\
\

\
\

\
\

\
\

\
\

\
\

\
\

Checkpoints {.western}
===========

There will be 3 checkpoints to ensure that the calculator is on track
for completion. They are required, and are worth a substantial part of
your grade (see breakdown below). You must submit them on time to
receive full credit.

\

Checkpoint 1: Parsing one line of input {.western}
---------------------------------------

-   Your main() method creates a Scanner, reads one line of input, and
    passes that input to *produceAnswer*.

\

-   *produceAnswer* breaks up that line of input into three Strings: the
    first operand (fraction), the operator (+ - \* /), and the second
    operand (fraction). Each of these Strings should be stored in
    variables inside *produceAnswer*.

\

-   *produceAnswer* returns the second operand. For example,
    produceAnswer(“1\_2/3 + 4\_5/6”) returns “4\_5/6”.

\

-   main() prints the result returned by *produceAnswer*

\

\

**Checkpoint 2: Multiple lines of input, parsing fractions**

-   Your main() method now accepts input from the user multiple times
    (until the user types “quit”)

\

-   For each line of input, main calls *produceAnswer*() and prints the
    returned result

\

-   This time, *produceAnswer* must further parse each operand into 3
    integer variables, one each for the numerator, denominator, and
    whole portion (for mixed fractions or integers). Note that there are
    cases where not all 3 of these components are present (see below).

\

-   *produceAnswer* now must demonstrate you have parsed fractions
    properly by returning a string that describes each component of the
    second operand: the whole number portion (or 0 if not specified),
    the numerator (or 0 if not specified), and the denominator (or 1 if
    not specified). Examples:

    -   produceAnswer("5\_3/4 - 6\_5/8") returns "whole:6 numerator:5
        denominator:8"

    -   produceAnswer("-3/7 - 20") returns "whole:20 numerator:0
        denominator:1"

    -   produceAnswer(“-32 - 27/21”) returns "whole:0 numerator:27
        denominator:21"

***Note:****your spelling, casing, and spacing must match these examples
exactly, or the tests will fail and you will not receive full credit.*

\

***Note:****produceAnswer must parse****both****operands even though the
returned String describes only the second one*

\

\

\

\

\

\

\

**Checkpoint 3: Evaluation**

-   *produceAnswer* must now evaluate the formula it is given
    (performing addition, subtraction, multiplication, and division,
    based on the operator specified), and return the actual answer of
    that calculation (instead of just returning the second operand).

\

-   The *answer* need not be reduced, and need not be a mixed fraction.
    But it must be correct.

\

-   All kinds of *input values* the user might enter must be accepted,
    including simple fractions, improper fractions, mixed fractions, and
    integers.

\
 {.western}
-

Final Project: All requirements complete {.western}
========================================

-   All answers must be reduced

-   All tests should pass

\
\

Extra Credit {.western}
============

*Do not spend time on extra credit until you have everything else
working properly.*

\

1.  Multiple Operations {.western style="margin-top: 0in; line-height: 100%; page-break-inside: auto; widows: 2; orphans: 2; page-break-after: auto"}
    -------------------

-   This extra credit will be awarded for calculators that can take in
    arbitrarily many values and operators. This will only be tested with
    compatible operations such that all equations are evaluated from
    left to right, in the order they appear (i.e. you will not need to
    worry about order of operations).

\
\

**Input**

**Output**

**1 + 2 + 3**

6

**3/4 \* 4**

3

**-1/2 \* 4 + 3/4**

-1\_1/4

**5\_3/4 - -6\_8/8 - 5\_3/4**

7

\
\

\
\

\
\

\
\

2.   {.western style="margin-top: 0in; line-height: 100%; page-break-inside: auto; widows: 2; orphans: 2; page-break-after: auto"}

    **Input**

    **Output**

    **1/0 + 1**

    ERROR: Cannot divide by zero.

    **1 ++ 2**

    ERROR: Input is in an invalid format.

    Error Handling

-   This extra credit will be awarded for calculators that do not crash
    when erroneous input is provided, but instead print useful error
    messages. Any error encountered based on user input should print
    “ERROR: ” to the screen followed by an informative error message.

\
\

\
\

\
\

\
\

\
\

\
\

Grading Breakdown {.western}
=================

  -------------------------------- ----------------
  **REQUIREMENT**                  **POINTS**

  **Input Parsing**                15

  **Addition & Subtraction**       20

  **Multiplication & Division**    20

  **Fraction Reduction**           15

  **Output is a Mixed Fraction**   15

  **Handles Mixed Fractions**      10

  **Handles Negatives**            15

  **Checkpoints**                  35

  **Code Comments**                5

  **TOTAL**                        **150 points**

  \                                \
                                   

  *Extra: Multiple Operations*     4

  *Extra: Error Handling*          4
  -------------------------------- ----------------

\
\

![](data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAL4AAAAUCAYAAAAz84cVAAAACXBIWXMAAA66AAAOeAHsc4MeAAAAUklEQVR4nO3SMQEAMAyAsB31b7mT0YNEAQezuw9q5joALhifJOOTZHySjE+S8UkyPknGJ8n4JBmfJOOTZHySjE+S8UkyPknGJ8n4JBmfJOOT9AGrGwNO/q75FAAAAABJRU5ErkJggg==)

rev. 6/15/15

ONLINE www.tealsk12.org

\

\

This work is licensed under a [Creative Commons
Attribution-NonCommercial-ShareAlike 4.0 International
License](http://creativecommons.org/licenses/by-nc-sa/4.0/)

ONLINE www.tealsk12.org

 

\

\

![](data:image/png;base64,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)

0

\

\
