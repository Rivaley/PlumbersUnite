<?php

$servername = "localhost";
$username = "user";
$password = "password";
$dbname = "Plumbers_Unite";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
  die("Connection failed: " . $conn->connect_error);
}



//insert into the table
// prepare and bind
$stmt = $conn->prepare("INSERT INTO pet ( petID, petType, petDescrip, petPicture, petWeight) VALUES (?, ?, ?, ?, ?)");
$stmt->bind_param("sssss", $petID, $petType, $petDescrip,$petPicture, $petWeight);


$petID= $_POST['petID'];
$petType = $_POST['petType'];
$petDescrip= $_POST['petDescrip'];
$petPicture = $_POST['petPicture'];
$petWeight = $_POST['petWeight'];


$stmt->execute();

echo "New records created successfully". $petID. " ".$petType." ".$petDescrip." ".$petPicture;




 ?>
