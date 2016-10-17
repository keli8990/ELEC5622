# E-Health Monitor by WebRTC
ELEC5622 Assignment :joy:

# Project Overview
The project designed by the group 5 is mainly used to help old people who have poor health conditions frequently, which monitors their health condition dynamically and offer a video file to describe their problems virtually and remotely. It will also help the doctors to save time to know more medical records about the patients before the appointment.

# Aims
* Development of a webpage which contains detailed the health data, its relative safe range and corresponding health suggestion for patients
* Development of a remote media file as a convenient method for doctors to ask for information

# Concept
User data shall be classified according to the username and password, so that each user is able to login on the system and view their personal health data. Each user has different types of health information. All these raw health data are measured by E-Health devices, like Glucometer Sensor, Patient Position Sensor (Accelerometer), Electrocardiogram Sensor (ECG) and Electromyography Sensor (EMG). According to the usage of data, it will be analysed separately. For each type of data, the system already has a normal range. If the user’s personal data exceed/below the range, the system will send an alert to the user. Thus, user’s body features can be monitored.<br><br>
Besides, the user can subscribe more than one doctor from the website. In other words, users are able to send their health information (like ECG, EMG parameter) and a short video to describe their symptoms to doctor visually. Also, the patients’ clinical history will be saved as digital format, doctors will take both the health parameters and the video content into account to present a relative accurate diagnosis.<br><br>
The recording function provided by WebRTC, this allows doctors is able to view patients’ status remotely. WebRTC doesn’t need any specific requirement and installation. Moreover, the code for recording, which responses for maintaining call histories between each patient and doctor. Thus, hospital communications can be built and integrated with the healthcare WebRTC project.
