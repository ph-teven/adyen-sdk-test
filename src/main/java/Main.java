import com.adyen.model.nexo.Amount;
import com.adyen.model.terminal.TerminalAPIResponse;
import com.adyen.terminal.serialization.TerminalAPIGsonBuilder;

public class Main {

    public static void main(String[] args) {
        String json = "{\n" +
                "  \"SaleToPOIResponse\": {\n" +
                "    \"MessageHeader\": {\n" +
                "      \"MessageCategory\": \"Payment\",\n" +
                "      \"MessageClass\": \"Service\",\n" +
                "      \"MessageType\": \"Response\",\n" +
                "      \"POIID\": \"xxx\",\n" +
                "      \"ProtocolVersion\": \"3.0\",\n" +
                "      \"SaleID\": \"unknown\",\n" +
                "      \"ServiceID\": \"Q\"\n" +
                "    },\n" +
                "    \"PaymentResponse\": {\n" +
                "      \"POIData\": {\n" +
                "        \"POIReconciliationID\": \"1000\",\n" +
                "        \"POITransactionID\": {\n" +
                "          \"TimeStamp\": \"2021-05-26T16:51:43.000Z\",\n" +
                "          \"TransactionID\": \"xxx\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"PaymentReceipt\": [],\n" +
                "      \"PaymentResult\": {\n" +
                "        \"AmountsResp\": {\n" +
                "          \"AuthorizedAmount\": 1379,\n" +
                "          \"Currency\": \"CZK\"\n" +
                "        },\n" +
                "        \"AuthenticationMethod\": [\n" +
                "          \"OnlinePIN\"\n" +
                "        ],\n" +
                "        \"CurrencyConversion\": [\n" +
                "          {\n" +
                "            \"ConvertedAmount\": {\n" +
                "              \"AmountValue\": 48.32,\n" +
                "              \"Currency\": \"GBP\"\n" +
                "            },\n" +
                "            \"CustomerApprovedFlag\": true,\n" +
                "            \"Markup\": 3,\n" +
                "            \"Rate\": 0.035\n" +
                "          }\n" +
                "        ],\n" +
                "        \"CustomerLanguage\": \"en\",\n" +
                "        \"OnlineFlag\": true,\n" +
                "        \"PaymentAcquirerData\": {\n" +
                "          \"AcquirerPOIID\": \"xxx\",\n" +
                "          \"AcquirerTransactionID\": {\n" +
                "            \"TimeStamp\": \"2021-05-26T16:51:43.000Z\",\n" +
                "            \"TransactionID\": \"xxx\"\n" +
                "          },\n" +
                "          \"ApprovalCode\": \"123456\",\n" +
                "          \"MerchantID\": \"xxx\"\n" +
                "        },\n" +
                "        \"PaymentInstrumentData\": {\n" +
                "          \"CardData\": {\n" +
                "            \"CardCountryCode\": \"826\",\n" +
                "            \"EntryMode\": [\n" +
                "              \"Contactless\"\n" +
                "            ],\n" +
                "            \"MaskedPan\": \"541333 **** 9999\",\n" +
                "            \"PaymentBrand\": \"mc\",\n" +
                "            \"SensitiveCardData\": {\n" +
                "              \"CardSeqNumb\": \"33\",\n" +
                "              \"ExpiryDate\": \"0228\"\n" +
                "            }\n" +
                "          },\n" +
                "          \"PaymentInstrumentType\": \"Card\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"Response\": {\n" +
                "        \"AdditionalResponse\": \"xxx\",\n" +
                "        \"Result\": \"Success\"\n" +
                "      },\n" +
                "      \"SaleData\": {\n" +
                "        \"SaleTransactionID\": {\n" +
                "          \"TimeStamp\": \"2021-05-26T16:51:33.026Z\",\n" +
                "          \"TransactionID\": \"xxx\"\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}\n";

        TerminalAPIResponse terminalAPIRequest = TerminalAPIGsonBuilder.create().fromJson(json, TerminalAPIResponse.class);

        Amount amount = terminalAPIRequest.getSaleToPOIResponse().getPaymentResponse().getPaymentResult().getCurrencyConversion().get(0).getConvertedAmount();

        System.out.println(amount.getValue().toString());
    }
}
