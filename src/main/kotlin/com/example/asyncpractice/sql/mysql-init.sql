-- damoa.mbr definition

CREATE TABLE `mbr` (
                       `ID` varchar(32) NOT NULL COMMENT '회원 ID',
                       `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
                       `MODIFY_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시',
                       `FLAG` varchar(1) NOT NULL DEFAULT '1' COMMENT '삭제여부',
                       `MBR_NM` varchar(20) NOT NULL COMMENT '회원명',
                       `AGE` int DEFAULT NULL COMMENT '회원나이',
                       `GNDR_TYP` varchar(1) DEFAULT NULL COMMENT '성별유형',
                       `JOIN_DATE` timestamp NULL DEFAULT NULL COMMENT '가입일시',
                       PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- damoa.mbr_grp definition

CREATE TABLE `mbr_grp` (
                           `ID` varchar(32) NOT NULL COMMENT '회원그룹 ID',
                           `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
                           `MODIFY_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시',
                           `FLAG` varchar(1) NOT NULL DEFAULT '1' COMMENT '삭제여부',
                           `GRP_NM` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '회원그룹명',
                           PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- damoa.clndr definition

CREATE TABLE `clndr` (
                         `ID` varchar(32) NOT NULL COMMENT '캘린더 ID',
                         `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
                         `MODIFY_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시',
                         `FLAG` varchar(1) NOT NULL DEFAULT '1' COMMENT '삭제여부',
                         `GRP_ID` varchar(32) NOT NULL COMMENT '회원그룹 ID(FK)',
                         `CLNDR_NM` varchar(20) DEFAULT NULL COMMENT '캘린더명',
                         `CLNDR_TYP` varchar(2) NOT NULL COMMENT '캘런더 유형',
                         PRIMARY KEY (`ID`),
                         KEY `GRP_ID` (`GRP_ID`),
                         CONSTRAINT `clndr_ibfk_1` FOREIGN KEY (`GRP_ID`) REFERENCES `mbr_grp` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- damoa.mbr_clndr_rltn definition

CREATE TABLE `mbr_clndr_rltn` (
                                  `MBR_ID` varchar(32) NOT NULL COMMENT '회원 ID(FK)',
                                  `CLNDR_ID` varchar(32) NOT NULL COMMENT '캘린더 ID(FK)',
                                  `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
                                  `MODIFY_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시',
                                  `FLAG` varchar(1) NOT NULL DEFAULT '1' COMMENT '삭제여부',
                                  `DSPL_YN` varchar(1) NOT NULL DEFAULT '1' COMMENT '기본 표시 여부',
                                  `DSPL_SEQ` int NOT NULL COMMENT '표시 순서',
                                  `PUSH_YN` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '1' COMMENT '푸시여부',
                                  PRIMARY KEY (`CLNDR_ID`,`MBR_ID`),
                                  KEY `MBR_ID` (`MBR_ID`),
                                  CONSTRAINT `mbr_clndr_rltn_ibfk_1` FOREIGN KEY (`MBR_ID`) REFERENCES `mbr` (`ID`),
                                  CONSTRAINT `mbr_clndr_rltn_ibfk_2` FOREIGN KEY (`CLNDR_ID`) REFERENCES `clndr` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- damoa.mbr_grp_rltn definition

CREATE TABLE `mbr_grp_rltn` (
                                `MBR_ID` varchar(32) NOT NULL COMMENT '회원 ID(FK)',
                                `GRP_ID` varchar(32) NOT NULL COMMENT '회원그룹 ID(FK)',
                                `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
                                `MODIFY_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시',
                                `FLAG` varchar(1) NOT NULL DEFAULT '1' COMMENT '삭제여부',
                                `RLTN_TYP` varchar(2) NOT NULL COMMENT '관계유형',
                                `GRP_SEQ` int NOT NULL COMMENT '그룹 표현 순서',
                                `JOIN_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '그룹 참여일시',
                                `WDRW_DATE` timestamp NULL DEFAULT NULL COMMENT '그룹 탈퇴일시',
                                `WDRW_YN` varchar(1) NOT NULL DEFAULT '0' COMMENT '탈퇴여부',
                                PRIMARY KEY (`GRP_ID`,`MBR_ID`),
                                KEY `MBR_ID` (`MBR_ID`),
                                CONSTRAINT `mbr_grp_rltn_ibfk_1` FOREIGN KEY (`MBR_ID`) REFERENCES `mbr` (`ID`),
                                CONSTRAINT `mbr_grp_rltn_ibfk_2` FOREIGN KEY (`GRP_ID`) REFERENCES `mbr_grp` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- damoa.pln definition

CREATE TABLE `pln` (
                       `ID` varchar(32) NOT NULL COMMENT '일정 ID',
                       `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
                       `MODIFY_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시',
                       `FLAG` varchar(1) NOT NULL DEFAULT '1' COMMENT '삭제여부',
                       `CLNDR_ID` varchar(32) NOT NULL COMMENT '캘린더 ID(FK)',
                       `PLN_NM` varchar(20) NOT NULL COMMENT '일정명',
                       `PLN_START_DT` timestamp NOT NULL COMMENT '일정시작일시',
                       `PLN_END_DT` timestamp NOT NULL COMMENT '일정종료일시',
                       `PLN_COLOR` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '일정표시색상',
                       `MBR_ID` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '생성자 회원 ID(FK)',
                       PRIMARY KEY (`ID`),
                       KEY `CLNDR_ID` (`CLNDR_ID`),
                       KEY `CREATOR` (`MBR_ID`),
                       CONSTRAINT `pln_ibfk_1` FOREIGN KEY (`CLNDR_ID`) REFERENCES `clndr` (`ID`),
                       CONSTRAINT `pln_ibfk_2` FOREIGN KEY (`MBR_ID`) REFERENCES `mbr` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- damoa.pln_hst definition

CREATE TABLE `pln_hst` (
                           `PLN_ID` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '일정 ID(FK)',
                           `MBR_ID` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '회원 ID(FK)',
                           `HST_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '일정작업일시',
                           `CREATE_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
                           `MODIFY_DATE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일시',
                           `FLAG` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '1' COMMENT '삭제여부',
                           `HST_TYP` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '이력유형',
                           PRIMARY KEY (`PLN_ID`,`HST_DATE`,`MBR_ID`),
                           KEY `pln_hst_FK_1` (`MBR_ID`),
                           CONSTRAINT `pln_hst_FK` FOREIGN KEY (`PLN_ID`) REFERENCES `pln` (`ID`),
                           CONSTRAINT `pln_hst_FK_1` FOREIGN KEY (`MBR_ID`) REFERENCES `mbr` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;