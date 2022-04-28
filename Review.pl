%Problem Solving

university(pheonix).
university(brighton).
university(sussex).

accredited(pheonix).
accredited(sussex).

online(pheonix).
online(brighton).
vocational(U):-university(U).
science(pheonix).
hacking(brighton).
hacking(sussex).

accept_caribbean(brighton).
accept_caribbean(sussex).

tarique:-hacking(University),vocational(University),accept_caribbean(University),
    online(University),not(accredited(University)),
    nl, write('Tarique can attend '), write(University),fail.

joy:- (science(University);hacking(University)), online(University),
    nl, write('Joy can attend '), write(University),fail.

danielle:-(accept_caribbean(University); online(University)),accredited(University),
    nl, write('Joy can attend '), write(University),fail.

univ:-tarique;joy;danielle.


%Arithmetic Question

payroll:-nl,write('Enter employee name: '),
    nl, read(Name),
    nl, write('Enter salary: '),
    nl, read(Salary),
    caltax(Salary,Tax),
    (Salary > 20000 -> Nht is Salary * 0.05;Nht is Salary * 0.02),
    Net_Sal is Salary - (Tax+Nht),
    display(Name,Tax,Nht,Net_Sal).

caltax(Salary,Tax):- Salary >= 1,Salary < 1001 -> Tax is Salary * 0.07;
                     Salary >= 10001,Salary =< 30000 -> Tax is Salary * 0.06;
                     Salary > 30000 -> Tax is Salary * 0.04.

display(Name,Tax,Nht,Net_Sal):- nl, write('***Payroll***'),
    nl, write('Name: '), write(Name),
    nl, write('Tax: '), write(Tax),
    nl, write('NHT: '), write(Nht),
    nl, write('Net Salary: '), write(Net_Sal),
    runagain.

runagain:-nl,nl, write('Do you wish to run the program again? '),
            nl,read(Ans),
            ( (Ans == y; Ans == 'Y') -> payroll;
            nl,write(' Bye ')).

