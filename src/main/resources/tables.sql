CREATE TABLE `case_table` (
  `id` bigint NOT NULL,
  `date_reported` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `investigating_officer_id` bigint DEFAULT NULL,
  `legal_action_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo99u7d4892lbqg4yucp15bl1a` (`investigating_officer_id`),
  KEY `FK69dbotqasb3ce8o773d46vj89` (`legal_action_id`),
  CONSTRAINT `FK69dbotqasb3ce8o773d46vj89` FOREIGN KEY (`legal_action_id`) REFERENCES `legal_action` (`id`),
  CONSTRAINT `FKo99u7d4892lbqg4yucp15bl1a` FOREIGN KEY (`investigating_officer_id`) REFERENCES `investigating_officer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `evidence` (
  `id` bigint NOT NULL,
  `evidence_details` varchar(255) DEFAULT NULL,
  `evidence_type` varchar(255) DEFAULT NULL,
  `case_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmsxmgvkrvuxe5bim8l9dysh0u` (`case_id`),
  CONSTRAINT `FKmsxmgvkrvuxe5bim8l9dysh0u` FOREIGN KEY (`case_id`) REFERENCES `case_table` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `investigating_officer` (
  `id` bigint NOT NULL,
  `contact` varchar(255) DEFAULT NULL,
  `dept` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `legal_action` (
  `id` bigint NOT NULL,
  `action_id` varchar(255) DEFAULT NULL,
  `action_taken` varchar(255) DEFAULT NULL,
  `date_action` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `suspect` (
  `id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `age` varchar(255) DEFAULT NULL,
  `crime_history` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `case_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKavutrbw3pryv1pua2p6d56y9n` (`case_id`),
  CONSTRAINT `FKavutrbw3pryv1pua2p6d56y9n` FOREIGN KEY (`case_id`) REFERENCES `case_table` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `victim` (
  `id` bigint NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `case_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKis99lryocuoyv5igli45g381` (`case_id`),
  CONSTRAINT `FKis99lryocuoyv5igli45g381` FOREIGN KEY (`case_id`) REFERENCES `case_table` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
