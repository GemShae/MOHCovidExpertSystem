
:- dynamic stats/2. %statistics hold total persons (first argument) and total persons diagnosed (second argument)
:- dynamic statsRegular/2.
:- dynamic riskCountry/1. %riskCountry holds at risk countries

stats(0,0).
statsRegular(0,0).
riskCountry(jamaica).

/*haveCovid:-diagnose(Condition),
    nl, write('Diagnoses: '), write(Condition),
    undo. */

%Have Covid
/*List of Symptoms */
% [fever,cough,tiredness,noTaste,noSmell,runningNose,soreThroat,headache,pains,diarrhoea,irritatedEyes,blurredVision,dizziness,
% difficultyBreathing,shortnessofBreath,lossOfSpeech,lossOfMobility,confusion,chestPain,rashOnSkin,fainting,nausea,vomitting,continuousCough].

/*Diagnoses Identification Facts for Covid and Variant */
listSymptoms([fever,cough,tiredness,noTaste,noSmell,runningNose,soreThroat,headache],regularSymptoms).
listSymptoms([fever,cough],covid).
listSymptoms([pains,diarrhoea,irritatedEyes,dizziness,blurredVision],mildSymptoms).
listSymptoms([fever,cough,tiredness,noTaste,noSmell,runningNose,soreThroat,headache,pains,diarrhoea,irritatedEyes,dizziness,blurredVision],mildSymptoms).


listSymptoms([difficultyBreathing,shortnessofBreath,lossOfSpeech,lossOfMobility,confusion,chestPain,rashOnSkin,fainting],severeSymptoms).
listSymptoms([pains,diarrhoea,irritatedEyes,dizziness,blurredVision,difficultyBreathing,shortnessofBreath,lossOfSpeech,lossOfMobility,confusion,chestPain,rashOnSkin,fainting],severeSymptoms).

listSymptoms([fever,cough,tiredness,noTaste,noSmell,runningNose,soreThroat,headache,pains,diarrhoea,irritatedEyes,dizziness,blurredVision,difficultyBreathing,shortnessofBreath,lossOfSpeech,lossOfMobility,confusion,chestPain,rashOnSkin,fainting],severeSymptoms).

listSymptoms([_],covidFree).

listSymptomsVariant([fever,cough,tiredness,noTaste,noSmell,runningNose,soreThroat,headache,pains,diarrhoea,irritatedEyes,dizziness,blurredVision,
              nausea,vomiting],deltaVariant).
listSymptomsVariant([fever,cough,tiredness,noTaste,noSmell,runningNose,soreThroat,headache,pains,diarrhoea,irritatedEyes,dizziness,blurredVision,
             continuousCough],muVariant).
listSymptomsVariant([_],noVariant).


/*At Risk Facts for having Covid */
lengthOfSymptoms(X,Count,Risk):-findlength(X,Count), Count>=5 -> Risk is 5;Risk is 0.
lengthOfDisease(X,Count,Risk):-findlength(X,Count), Risk is Count.
covidExposureEvents(CovidExposure,ExposureRisk):-CovidExposure == true -> ExposureRisk is 5; ExposureRisk is 0.
improperProtocolEvents(ImproperProtocols,Risk):- ImproperProtocols == true -> Risk is 5; Risk is 0.
oldYoungAge(Age,Risk):- Age>60 -> Risk is 5; Risk is 0.


/*At Risk Rule for having Covid */
findlength([],X):-X is 0.
findlength([_|Tail],Count):-findlength(Tail,Prev),Count is Prev+1.

/* Assigns values based on whether person has partaked. At Risk */
exerciseValue(Exercise,ExerValue):- Exercise == false -> ExerValue is 1
    %(exerValue(ExerValue),ExerValue==1),
    %nl, write('Exercise regularly. Moving prevents hypertension. Physical activity is crucial.')
    ; ExerValue is 0.
alchoholValue(Alcohol,AlchValue):- Alcohol == true -> AlchValue is 1
    %nl, write('Limit the alcohol. Drinking too much alcohol can lead to high blood pressure.'),
    %nl, write('For women: no more than one drink per day. For men: No more than two.')
    ; AlchValue is 0.
riskCountryValue(Country,RiskCValue):- (riskCountry(Country) -> RiskCValue is 1; RiskCValue is 0).
bloodPressureCalculator(systolicValue,diastolicValue,BPValue):- (systolicValue <90; distolicValue <60)-> BPValue is 5; %low pressure
     BPValue is 0. %normal pressure

%Asserts riskCountry fact with country entered as argument
saveRiskCountry(Country):-riskCountry(Country)-> nl, write('Country already recorded.'); (assert(riskCountry(Country)),
    nl, write(Country), write(' is added to the database as a risk country')).


bloodPressure(low).
bloodPressure(high).


%Shows Stats for people with high blood pressure
displayHighBloodPressureStats:-stats(TP,THBP),
    nl, write('Total Persons: '), write(TP),
    nl, write('Total Persons with High Blood Pressure: '), write(THBP),
    findPercentage(THBP,TP,Percent),
    nl, write('Percentage of persons with high blood pressure: '), write(Percent), write('%').

%Finds all percentages needed
findPercentage(Subset,Total,Percent):-Percent is ( (Subset/Total)*100 ).


%Calculates the height from feet and inches to meters
heightInMeters(HeightFeet,HeightInches,HeightMeters):-HeightMeters is (HeightFeet*0.3048)+(HeightInches*0.0254).

%Calculates weight in pounds to kilograms
weightInKilo(WeightPounds,WeightKilo):- WeightKilo is (WeightPounds*0.4536).

%Convert Celsius to Fahrenheit - USED
tempInFah(TempCel,TempFah):- TempFah is ( (TempCel*1.8)+32).

%Use Fahrenheit to check is patient have fever - USED
checkForFever(TempFah,Fever):- TempFah >=100.4 -> Fever is 1; Fever is 0.

%Calulates BMI and assigns a value based on it
bmiCalculator(WeightKilo,HeightMeters,BMI,BmiValue):-BMI is WeightKilo/(HeightMeters*HeightMeters),
    (BMI =< 18.5 -> BmiValue is -1,
     nl, write('Underweight: Consult your doctor on benefitial habits to improve your weight balance.'),
     nl, write('Eat more healthy foods to gain and maintain a healthier weight'); %Underweight
     BMI >= 18.5, BMI =<24.9 -> BmiValue is 0,
     nl, write('Healthy Weight: Continue to maintain a healthy lifestyle'); %Healthy Weight
     BMI >= 25.0, BMI =<29.9 -> BmiValue is 1,
     nl, write('Overweight: Eat a balanced diet. Eating healthy foods can help keep your blood pressure under control.'),
     nl, write('Get plenty of fruits and vegetables, foods rich in potasium and limit excess calories,fat and sugar.'); %Overweight
     BMI >= 30.0 -> BmiValue is 2),
     nl, write('Obese:  Eat a balanced diet. Eating healthy foods can help keep your blood pressure under control.'). %Obesity


%exerValue(1).
%exerValue(0).

/*test:-nl,write('Exercise?: '),
    nl, read(Exercise),
    exerciseValue(Exercise,ExerValue),
    nl, write(ExerValue). */


%Calculates the total risk value
totalRiskValues(BmiValue,ExerValue,AlchValue,StressValue,DiaValue,RiskCValue,TotalRisk):-TotalRisk is BmiValue+ExerValue+AlchValue+StressValue+
    DiaValue+RiskCValue.

%If total risk value >=3 patient at risk
bloodPressureRisk(TotalRisk,HBPValue):- TotalRisk>=3 -> nl, write(' At risk for high blood pressure'), HBPValue is 1;
      nl, write('Not at risk for high blood pressure'), HBPValue is 0,
      updateHBPStatistics(HBPValue).

%Updates the statistics on overall high blood pressure
updateHBPStatistics(HBPValue):-displayHighBloodPressureStats(TP,THBP), Newtotal is TP+1, NewHBP is THBP+HBPValue,
    retractall(displayHighBloodPressureStats(_,_)),
    assert(displayHighBloodPressureStats(Newtotal,NewHBP)).








