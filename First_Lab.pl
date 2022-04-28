% Prolog knowledgebase consists of facts and rules.
% File extension .pl

%Facts describe attributes or relationships

%Predicate - begins with lowercase

%Argument(s)/(atom) in bracket
%            - begins with lowercase

% If spaces or capital to be used we use single quotes
male('john tom').
male('John').


male(duhon).
male(denie).
female(tara).
female(bibi).

student(duhon).
student(tara).
tourist(denie).
tourist(bibi).

ww2vet(bibi).
dropout(tara).
dropout(duhon).

%Variables
%They are only used in rules or the interpreter
%Begin with capital


%Fact - relationship
%Reads from left to right
parent_of(denie,duhon).
parent_of(bibi, denie).
parent_of(bibi,tara).

%rules
%header    :-body

%Who is a parent
parent(Who):-parent_of(Who,_).
%who is a mother
mother(Mother):-female(Mother),parent_of(Mother,_).
%who is a father
father(Father):-male(Father),parent_of(Father,_).
%Who is a son
son(Parent,Son):-male(Son),parent_of(Parent,Son).
%Who is a daughter
daughter(D):-parent_of(_,D),female(D).

%Who is a dropout
maledropout(Dropout):-male(Dropout),dropout(Dropout).

%Who is a pickney
pickney(Child):-parent_of(_,Child).
% dropoutpickneys(DropoutPickney):-pickney(DropoutPickey),dropout(DropoutPickney).
%

%Grandparent
grandparent(G):-parent_of(G,P),parent_of(P,_).

%Siblings
siblings(S1,S2):-parent_of(P,S1),parent_of(P,S2),S1\=S2.
malesib(MS):-(siblings(MS,_),male(MS));(siblings(_MS),male(MS)).

%Denie's Parent
denieparent(DP):-parent_of(DP,_).

%Aunt
aunt(Who):-siblings(Who,Sib2),parent(Sib2),female(Who).

%== comparison
%, and
%; or
%\= not equal to
%_ wildcard
%not - negates a fact
