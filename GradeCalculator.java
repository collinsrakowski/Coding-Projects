import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class GradeCalculator {

public static void main(String[] args) {
		
		String answer, inputGradeLetter, gradeLetter;
		
		double finalOverallScore = 0, avgToFinalLetterGrade, avgToFinalLetterGradeTop, avgToFinalLetterGradeBottom;
		double examGrade1=0, examGrade2=0, examFinal=0, avgLabGrade=0, avgProjectGrade = 0, participationAvg = 0, quizAvg = 0, totalWeight;
		double weightExam1, weightExam2, weightFinalGrade, weightLabs, weightProjects, weightParticipation, weightQuizzes;
		
		double currentScore;
		double currentGradeSum = 0;
		double currentWeightSum = 0;
		
		System.out.println("Grading Scale:");
		System.out.println("A\t90 - 100");
		System.out.println("B\t80 - 89");
		System.out.println("C\t70 - 79");
		System.out.println("D\t60 - 69");
		System.out.println("F\tbelow 60");
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("What letter grade do you want to achieve for the course?");
		inputGradeLetter = (keyboard.next()).toUpperCase();
		
		if (inputGradeLetter.equalsIgnoreCase("A")) {
			finalOverallScore = 90;
		} else if (inputGradeLetter.equalsIgnoreCase("B")) {
			finalOverallScore = 80;
		} else if (inputGradeLetter.equalsIgnoreCase("C")) {
			finalOverallScore = 70;
		} else if (inputGradeLetter.equalsIgnoreCase("D")) {
			finalOverallScore = 60;
		} else {
			System.out.println("The input is invalid.");
			System.exit(0);
		}
			
		
			System.out.print("Enter percentage weight below." +"\nExam 1:\t\t");
			weightExam1 = keyboard.nextDouble();
			
			System.out.print("Exam 2:\t\t");
			weightExam2 = keyboard.nextDouble();
			
			System.out.print("Final Exam:\t");
			weightFinalGrade = keyboard.nextDouble();
			
			System.out.print("Labs:\t\t");
			weightLabs = keyboard.nextDouble();
			
			System.out.print("Projects:\t");
			weightProjects = keyboard.nextDouble();
			
			System.out.print("Participation:\t");
			weightParticipation = keyboard.nextDouble();
			
			System.out.print("Quizzes:\t");
			weightQuizzes = keyboard.nextDouble();
			
			totalWeight = weightExam1 + weightExam2 + weightFinalGrade + weightLabs + weightProjects + weightParticipation + weightQuizzes;
		
		if (totalWeight == 100) {
			
		} else {
			System.out.println("Weights don't add up to 100, program exiting...");
			System.exit(0);
		}
		System.out.print("Do you know your exam 1 score?");
		answer = keyboard.next();
		
		if (answer.equalsIgnoreCase("y")||answer.equalsIgnoreCase("YES")) {
			System.out.print("Score received on exam 1:");	
			examGrade1 = keyboard.nextDouble();
			
			currentGradeSum = currentGradeSum + (examGrade1 * weightExam1);
			currentWeightSum = currentWeightSum + weightExam1;
			System.out.print("Do you know your exam 2 score?");
			answer = keyboard.next();
			
			if (answer.equalsIgnoreCase("y")||answer.equalsIgnoreCase("YES")) {
				System.out.print("Score received on exam 2:");	
				examGrade2 = keyboard.nextDouble();
				currentGradeSum = currentGradeSum + (examGrade2 * weightExam2);
				currentWeightSum = currentWeightSum + weightExam2;
				System.out.print("Do you know your final exam score?");
			
			answer = keyboard.next();
				if (answer.equalsIgnoreCase("y")||answer.equalsIgnoreCase("YES")) {
					System.out.print("Score received on final exam:");	
					examFinal = keyboard.nextDouble();
					currentGradeSum = currentGradeSum + (examFinal * weightFinalGrade);
					currentWeightSum = currentWeightSum + weightFinalGrade;
				} 
			}
		} 
		
		System.out.print("Do you know your lab average?");
		answer = keyboard.next();
		if (answer.equalsIgnoreCase("y")||answer.equalsIgnoreCase("YES")) {
			System.out.print("Average lab grade:");
			avgLabGrade = keyboard.nextDouble();
			currentGradeSum = currentGradeSum + (avgLabGrade * weightLabs); 
			currentWeightSum = currentWeightSum + weightLabs;
		} else {
			}
		
		System.out.print("Do you know your project average?");
		answer = keyboard.next();
		if (answer.equalsIgnoreCase("y")||answer.equalsIgnoreCase("YES")) {
			System.out.print("Average project grade:");
			avgProjectGrade = keyboard.nextDouble();
			currentGradeSum = currentGradeSum + (avgProjectGrade * weightProjects);
			currentWeightSum = currentWeightSum + weightProjects;
		} else {	
			}
		
		System.out.print("Do you know your participation average?");
		answer = keyboard.next();
		if (answer.equalsIgnoreCase("y")||answer.equalsIgnoreCase("YES")) {
			System.out.print("Average participation grade:");
			participationAvg = keyboard.nextDouble();
			currentGradeSum = currentGradeSum + (participationAvg * weightParticipation);
			currentWeightSum = currentWeightSum + weightParticipation;	
		} else {
		    }
		
		System.out.print("Do you know your quiz average?");
		answer = keyboard.next();
		if (answer.equalsIgnoreCase("y")||answer.equalsIgnoreCase("YES")) {
			System.out.print("Average quiz grade:");
			quizAvg = keyboard.nextDouble();
			currentGradeSum = currentGradeSum + (quizAvg * weightQuizzes);
			currentWeightSum = currentWeightSum + weightQuizzes;
		}
		
		currentScore = currentGradeSum / currentWeightSum;
		BigDecimal bd = new BigDecimal(currentScore).setScale(2, RoundingMode.HALF_UP);
		double currentScoreRounded = bd.doubleValue();
		
		avgToFinalLetterGradeTop = ((100 * finalOverallScore)-(currentGradeSum));
		avgToFinalLetterGradeBottom = (100 - currentWeightSum);
		avgToFinalLetterGrade = avgToFinalLetterGradeTop / avgToFinalLetterGradeBottom;	
		avgToFinalLetterGrade = Math.round(avgToFinalLetterGrade * 100.0)/100.0;
		
	
		if(currentScoreRounded >= 90) {
			gradeLetter = "A";
		} 
		else if (currentScoreRounded >= 80) {
			gradeLetter = "B";
		}
		else if (currentScoreRounded >= 70) {
			gradeLetter = "C";
		} 
		else if (currentScoreRounded >=60) {
			gradeLetter = "D";
		}
		else {
			gradeLetter = "F";
		}  
		System.out.println("Current grade score:" + currentScoreRounded);
		System.out.println("Your current letter grade:" + gradeLetter);
		
				if (totalWeight == 100) {
					
					if (inputGradeLetter.equalsIgnoreCase(gradeLetter)) {
					System.out.println("Congratulations! You received the " + gradeLetter + " that you wanted.");
					} 
					 
				else {
					
					if (avgToFinalLetterGrade > 100) {
							System.out.println("Unfortunately, a grade of " + inputGradeLetter + " is not possible."); 
							}  
					else {
							
						if (avgToFinalLetterGrade < 0) {
							System.out.println("You will receive at a least a grade of " + inputGradeLetter + ".");
							}
						else {
								System.out.println("In order to receive a grade of " + inputGradeLetter + "," +
								"\nyou need to score an average greater than" + "\nor equal to " +
								avgToFinalLetterGrade + " in the rest of the grade items.");
							}
					}
				
				}
			}
		keyboard.close();
		}
	}
