<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description>Uso de la trx de monitoreo. Busca Número Pedido SAP y lo graba en Excel</description>
   <name>SAP_monitoreo_interfaces</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>0</numberOfRerun>
   <pageLoadTimeout>30</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <testSuiteGuid>967c1979-948c-4308-9cd3-561f50a1ad23</testSuiteGuid>
   <testCaseLink>
      <guid>c5c4f856-911b-4245-8944-f6ec258cd91c</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Login_SAP</testCaseId>
   </testCaseLink>
   <testCaseLink>
      <guid>52bda1be-9bb0-4fde-a012-bb10f1861109</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/SAP_monitoreo_interfaces</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>5d10dff3-5ce3-437c-a07b-e6c3693b8827</id>
         <iterationEntity>
            <iterationType>ALL</iterationType>
            <value></value>
         </iterationEntity>
         <testDataId>Data Files/DGScenarios</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>5d10dff3-5ce3-437c-a07b-e6c3693b8827</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>out_n_pedido_sap</value>
         <variableId>0ed462ee-95c3-402d-b08a-441731ac2dc1</variableId>
      </variableLink>
   </testCaseLink>
</TestSuiteEntity>
