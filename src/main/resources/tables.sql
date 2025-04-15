CREATE TABLE `case_table` (
  `id` bigint NOT NULL,
  `case_id` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `date_reported` datetime DEFAULT NULL,
  `investigating_officer_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `evidence` (
  `id` bigint NOT NULL,
  `evidence_id` varchar(255) DEFAULT NULL,
  `evidence_type` varchar(255) DEFAULT NULL,
  `evidence_details` varchar(255) DEFAULT NULL,
  `case_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `investigating_officer` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `officer_id` varchar(255) DEFAULT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `dept` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `legal_action` (
  `id` bigint NOT NULL,
  `action_id` varchar(255) DEFAULT NULL,
  `action_taken` varchar(255) DEFAULT NULL,
  `date_action` datetime DEFAULT NULL,
  `case_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `suspect` (
  `id` bigint NOT NULL,
  `suspect_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `crime_history` varchar(255) DEFAULT NULL,
  `suspectcol` varchar(45) DEFAULT NULL,
  `case_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `victim` (
  `id` bigint NOT NULL,
  `victim_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `case_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
);


