@echo off
for /f "delims=" %%a in ('wmic OS Get localdatetime  ^| find "."') do set dt=%%a
set YYYY=%dt:~0,4%
set MM=%dt:~4,2%
set DD=%dt:~6,2%
set HH=%dt:~8,2%
set Min=%dt:~10,2%

set stamp=%YYYY%-%MM%-%DD%_%HH%-%Min%

cd C:\FarmaTesting\katalonProjects\Resources
copy "C:\FarmaTesting\katalonProjects\Resources\db_farmanet_escenarios_Andreani.xlsx" "C:\FarmaTesting\katalonProjects\Resources\procesados\db_farmanet_escenarios_Andreani- %stamp%.xlsx"
copy "C:\FarmaTesting\katalonProjects\Resources\db_farmanet_escenarios_Andreani.xlsx" "\\fsrvfs1hq\FNETFTPQ03\out\AutomatizacionTesting\db_farmanet_escenarios_Andreani- %stamp%.xlsx"
rem ftp -s:ftp_upload.txt
copy "C:\FarmaTesting\katalonProjects\Resources\backup\db_farmanet_escenarios_Andreani.xlsx" "C:\FarmaTesting\katalonProjects\Resources\db_farmanet_escenarios_Andreani.xlsx"

