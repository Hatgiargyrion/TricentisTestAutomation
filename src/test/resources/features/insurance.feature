#language:en
#encoding UTF-8

@insurance
Feature: Insurance

  Background: Access Tricentis and generate a person
    Given access to Tricentis
    And generate a person

  @automobile_insurance
  Scenario: CT01 Accomplish the insurance to car
    And go to tab "Automobile"
    And fill out the form "Enter Vehicle Data" in Automobile
    And click on "Next" button
    And fill out the form "Enter Insurant Data" in Automobile
    And click on "Next" button
    And fill out the form "Enter Product Data" in Automobile
    And click on "Next" button
    And fill out the form "Select Price Option" in Automobile
    And click on "Next" button
    And fill out the form "Send Quote" in Automobile
    When click on "Send" button
    Then validate the message "Sending e-mail success!"

  @truck_insurance
  Scenario: CT02 Accomplish the insurance to truck
    And go to tab "Truck"
    And fill out the form "Enter Vehicle Data" in Truck
    And click on "Next" button
    And fill out the form "Enter Insurant Data" in Truck
    And click on "Next" button
    And fill out the form "Enter Product Data" in Truck
    And click on "Next" button
    And fill out the form "Select Price Option" in Truck
    And click on "Next" button
    And fill out the form "Send Quote" in Truck
    When click on "Send" button
    Then validate the message "Sending e-mail success!"
