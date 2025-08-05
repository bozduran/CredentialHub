INSERT INTO company ( name, description, year_of_foundation) VALUES

( 'Microsoft', 'Global tech giant known for software and cloud services', 1975),
( 'Amazon Web Services', 'Leading cloud computing platform by Amazon', 2006),
( 'Google Cloud', 'Google’s cloud computing division', 2008),
( 'Cisco Systems', 'Networking hardware and telecommunications equipment provider', 1984),
( 'CompTIA', 'IT industry association providing vendor-neutral certifications', 1982),
( 'Oracle', 'Enterprise software and database company', 1977),
( '(ISC)²', 'Cybersecurity certification body', 1989),
( 'Red Hat', 'Provider of open source software solutions', 1993),
( 'EC-Council', 'Organization specializing in cybersecurity certifications', 2001),
( 'Google', 'Technology company offering IT and data analytics certifications', 1998);

INSERT INTO certificate ( name, description, price, version, company_id, field) VALUES
-- Microsoft certificates (company_id = 1)
( 'Microsoft Certified: Azure Fundamentals', 'Introductory certification for Azure cloud services', 99.0, 1, 1, 'IT'),
( 'Microsoft Certified: Power BI Data Analyst', 'Certification for data visualization and analytics with Power BI', 165.0, 1, 1, 'DEVELOPMENT'),
( 'Microsoft Certified: Security, Compliance, and Identity Fundamentals', 'Certification covering security principles and compliance', 99.0, 1, 1, 'CYBERSECURITY'),

-- Amazon Web Services certificates (company_id = 2)
('AWS Certified Solutions Architect – Associate', 'Certification for designing distributed systems on AWS', 150.0, 1, 2, 'IT'),
('AWS Certified Developer – Associate', 'Certification focused on developing applications on AWS', 150.0, 1, 2, 'DEVELOPMENT'),
( 'AWS Certified SysOps Administrator – Associate', 'Certification for deploying, managing, and operating systems on AWS', 150.0, 1, 2, 'PRODUCTION'),

-- Google Cloud certificates (company_id = 3)
('Google Associate Cloud Engineer', 'Certification on deploying and managing Google Cloud projects', 125.0, 1, 3, 'IT'),
( 'Professional Cloud Architect', 'Certification for designing and managing Google Cloud solutions', 200.0, 1, 3, 'IT'),
('Professional Data Engineer', 'Certification focusing on data processing and machine learning on Google Cloud', 200.0, 1, 3, 'DEVELOPMENT'),

-- Cisco Systems certificates (company_id = 4)
( 'CCNA (Cisco Certified Network Associate)', 'Entry-level networking certification', 300.0, 1, 4, 'IT'),
( 'CCNP Enterprise', 'Professional-level certification for enterprise networking', 400.0, 1, 4, 'IT'),
( 'Cisco CyberOps Associate', 'Certification for security operations center analysts', 300.0, 1, 4, 'CYBERSECURITY'),

-- CompTIA certificates (company_id = 5)
( 'CompTIA A+', 'Fundamental IT operational and technical support skills', 232.0, 1, 5, 'IT'),
( 'CompTIA Network+', 'Certification on networking concepts and troubleshooting', 338.0, 1, 5, 'IT'),
( 'CompTIA Security+', 'Entry-level cybersecurity certification', 370.0, 1, 5, 'CYBERSECURITY'),

-- Oracle certificates (company_id = 6)
( 'Oracle Certified Associate (OCA)', 'Fundamental database administration skills', 245.0, 1, 6, 'IT'),
( 'Oracle Certified Professional (OCP)', 'Advanced database management and development skills', 450.0, 1, 6, 'DEVELOPMENT'),
( 'Oracle Cloud Infrastructure Architect Associate', 'Certification on Oracle Cloud architecture', 300.0, 1, 6, 'IT'),

-- (ISC)² certificates (company_id = 7)
( 'Certified Information Systems Security Professional (CISSP)', 'Advanced cybersecurity certification', 749.0, 1, 7, 'CYBERSECURITY'),
( 'Certified Cloud Security Professional (CCSP)', 'Certification for cloud security professionals', 599.0, 1, 7, 'CYBERSECURITY'),
( 'Systems Security Certified Practitioner (SSCP)', 'Entry-level cybersecurity certification', 250.0, 1, 7, 'CYBERSECURITY'),

-- Red Hat certificates (company_id = 8)
( 'Red Hat Certified System Administrator (RHCSA)', 'Certification on Linux system administration', 400.0, 1, 8, 'IT'),
( 'Red Hat Certified Engineer (RHCE)', 'Advanced Linux administration certification', 600.0, 1, 8, 'PRODUCTION'),
('Red Hat Certified Specialist in Ansible Automation', 'Certification focused on automation using Ansible', 350.0, 1, 8, 'DEVELOPMENT'),

-- EC-Council certificates (company_id = 9)
( 'Certified Ethical Hacker (CEH)', 'Certification on ethical hacking techniques', 1199.0, 1, 9, 'CYBERSECURITY'),
( 'Certified Security Analyst (ECSA)', 'Advanced penetration testing certification', 799.0, 1, 9, 'CYBERSECURITY'),
( 'Licensed Penetration Tester (LPT)', 'Expert level penetration testing certification', 1299.0, 1, 9, 'CYBERSECURITY'),

-- Google certificates (company_id = 10)
( 'Google IT Support Professional Certificate', 'Entry-level IT support skills certification', 49.0, 1, 10, 'IT'),
( 'Google Data Analytics Professional Certificate', 'Certification for data analytics using Google tools', 49.0, 1, 10, 'DEVELOPMENT'),
( 'Google UX Design Professional Certificate', 'Certification focused on user experience design', 49.0, 1, 10, 'DEVELOPMENT');

INSERT INTO user_data (username, email, password)
VALUES
    ('Admin', 'john.doe@example.com', '$2a$13$LN2XV58FHgQP0Ut/l62V8eJQCtoUOhdUmeCuv.pLtk36uAV1/oOq6'),
    ('johndoe', 'john.doe@example.com', '$2a$13$LN2XV58FHgQP0Ut/l62V8eJQCtoUOhdUmeCuv.pLtk36uAV1/oOq6'),
    ('janedoe', 'jane.doe@example.com', '$2a$13$LN2XV58FHgQP0Ut/l62V8eJQCtoUOhdUmeCuv.pLtk36uAV1/oOq6'),
    ('mikesmith', 'mike.smith@example.com', '$2a$13$LN2XV58FHgQP0Ut/l62V8eJQCtoUOhdUmeCuv.pLtk36uAV1/oOq6'),
    ('sarahj', 'sarah.johnson@example.com', '$2a$13$LN2XV58FHgQP0Ut/l62V8eJQCtoUOhdUmeCuv.pLtk36uAV1/oOq6'),
    ('davidw', 'david.wilson@example.com', '$2a$13$LN2XV58FHgQP0Ut/l62V8eJQCtoUOhdUmeCuv.pLtk36uAV1/oOq6'),
    ('emilyb', 'emily.brown@example.com', '$2a$13$LN2XV58FHgQP0Ut/l62V8eJQCtoUOhdUmeCuv.pLtk36uAV1/oOq6'),
    ('robertm', 'robert.miller@example.com', '$2a$13$LN2XV58FHgQP0Ut/l62V8eJQCtoUOhdUmeCuv.pLtk36uAV1/oOq6'),
    ('lisat', 'lisa.thompson@example.com', '$2a$13$LN2XV58FHgQP0Ut/l62V8eJQCtoUOhdUmeCuv.pLtk36uAV1/oOq6'),
    ('michaelg', 'michael.garcia@example.com', '$2a$13$LN2XV58FHgQP0Ut/l62V8eJQCtoUOhdUmeCuv.pLtk36uAV1/oOq6'),
    ('jenniferl', 'jennifer.lee@example.com', '$2a$13$LN2XV58FHgQP0Ut/l62V8eJQCtoUOhdUmeCuv.pLtk36uAV1/oOq6');


-- Insert privileges
INSERT INTO privilege (id,name)
VALUES
                                 (0,'READ_PRIVILEGE'),
                                 (1,'WRITE_PRIVILEGE'),
                                 (2,'DELETE_PRIVILEGE'),
                                 (4,'MANAGE_USERS_PRIVILEGE');

-- Insert roles
INSERT INTO role (id,name)
VALUES
                            (0,'ROLE_ADMIN'),
                            (1,'ROLE_USER'),
                            (2,'ROLE_MODERATOR');

INSERT INTO users_roles(ROLE_ID, USER_ID)
VALUES
                    (0,1),
                    (1,2)

-- Extra reviews for certificate_id = 1
INSERT INTO review (stars, comment, created_date, update_date, certificate_id, userdata)
VALUES
    (5, 'Extremely valuable content and very well structured.', now(), now(), 1, 3),
    (4, 'Great overall but could use more updated cloud sections.', now(), now(), 1, 4),
    (3, 'Good for beginners, not much depth for experienced devs.', now(), now(), 1, 5),
    (2, 'I expected more hands-on labs or case studies.', now(), now(), 1, 6),
    (4, 'Nice mix of theory and practice. Worth the time.', now(), now(), 1, 1),
    (5, 'Helped me pass the exam on my first try. Highly recommended!', now(), now(), 1, 2),
    (1, 'Outdated and too expensive for what it offers.', now(), now(), 1, 6),
    (5, 'One of the best certs I’ve taken. Clear, concise, and relevant.', now(), now(), 1, 3);
