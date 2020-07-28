@echo off
for /f "delims=" %%a in ('wmic OS Get localdatetime  ^| find "."') do set dt=%%a
set YYYY=%dt:~0,4%
set MM=%dt:~4,2%
set DD=%dt:~6,2%
set HH=%dt:~8,2%
set Min=%dt:~10,2%
set Sec=%dt:~12,2%
set stamp=%YYYY%-%MM%-%DD%_%HH%-%Min%-%Sec%
::------------------------------------------------------------------------------------------------------------------------
:: Movemos el archivo utilizado con los datos que se generaron a la carpeta "\procesados"
copy "C:\FarmaTesting\katalonProjects\Resources\db_farmanet_escenarios.xlsx" "C:\FarmaTesting\katalonProjects\Resources\procesados\db_farmanet_escenarios- %stamp%.xlsx"
::------------------------------------------------------------------------------------------------------------------------
:: Obtenemos el día de la semana para determnar que archivo se utilizará en la siguiente corrida
Set "_=mon tues wed thurs fri sat sun"
For /f %%# In ('WMIC Path Win32_LocalTime Get DayOfWeek^|Findstr [1-7]') Do ( 
    Set dayofweek=%%#)
 
echo %dayofweek% 
:: Con esto mostrará el día de la semana que ha generado, y quedará congelada la pantalla hasta que pulsemos una tecla


REM ARCHIVO A EJECUTAR EL LUNES
IF "%dayofweek%"=="7" (
    copy "C:\FarmaTesting\katalonProjects\Resources\backup\db_farmanet_escenarios_lunes.xlsx" "C:\FarmaTesting\katalonProjects\Resources\db_farmanet_escenarios.xlsx"
    echo "backup\db_farmanet_escenarios_lunes.xlsx" 
    
REM ARCHIVO A EJECUTAR EL MARTES
) ELSE IF "%dayofweek%"=="1"  (
    copy "C:\FarmaTesting\katalonProjects\Resources\backup\db_farmanet_escenarios_martes.xlsx" "C:\FarmaTesting\katalonProjects\Resources\db_farmanet_escenarios.xlsx"
    echo "backup\db_farmanet_escenarios_martes.xlsx" 

REM ARCHIVO A EJECUTAR EL MIERCOLES
) ELSE IF "%dayofweek%"=="2"  (
    copy "C:\FarmaTesting\katalonProjects\Resources\backup\db_farmanet_escenarios_miercoles.xlsx" "C:\FarmaTesting\katalonProjects\Resources\db_farmanet_escenarios.xlsx"
    echo "backup\db_farmanet_escenarios_miercoles.xlsx" 

REM ARCHIVO A EJECUTAR EL JUEVES
) ELSE IF "%dayofweek%"=="3"  (
    copy "C:\FarmaTesting\katalonProjects\Resources\backup\db_farmanet_escenarios_jueves.xlsx" "C:\FarmaTesting\katalonProjects\Resources\db_farmanet_escenarios.xlsx"
    echo "backup\db_farmanet_escenarios_jueves.xlsx" 

REM ARCHIVO A EJECUTAR EL VIERNES
) ELSE IF "%dayofweek%"=="4"  (
    copy "C:\FarmaTesting\katalonProjects\Resources\backup\db_farmanet_escenarios_viernes.xlsx" "C:\FarmaTesting\katalonProjects\Resources\db_farmanet_escenarios.xlsx"
    echo "backup\db_farmanet_escenarios_viernes.xlsx" 

REM ARCHIVO A EJECUTAR EL SABADO
) ELSE IF "%dayofweek%"=="5"  (
    copy "C:\FarmaTesting\katalonProjects\Resources\backup\db_farmanet_escenarios_sabado.xlsx" "C:\FarmaTesting\katalonProjects\Resources\db_farmanet_escenarios.xlsx"
    echo "backup\db_farmanet_escenarios_sabado.xlsx" 

REM ARCHIVO A EJECUTAR EL DOMINGO    
) ELSE IF "%dayofweek%"=="6"  (
    copy "C:\FarmaTesting\katalonProjects\Resources\backup\db_farmanet_escenarios_domingo.xlsx" "C:\FarmaTesting\katalonProjects\Resources\db_farmanet_escenarios.xlsx"
    echo "backup\db_farmanet_escenarios_domingo.xlsx" 
) ELSE (
    REM default case...
)
