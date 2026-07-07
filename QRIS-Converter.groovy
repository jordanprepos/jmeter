import groovy.json.JsonBuilder
import groovy.json.JsonOutput
//import javax.xml.bind.DatatypeConverter
//import groovy.util.Base64;
//import org.apache.commons.codec.binary.Base64
import org.apache.commons.codec.digest.DigestUtils
import java.security.MessageDigest
import java.util.Random

Random random = new Random()
int randomTrnNo = random.nextInt(1000)
int randomRefNo = random.nextInt(1000)

def jsonMap = [:]
def valueLogin = "${login}"
def valuePassword= "${password}"
def valueSecret= "${secretKey}"
def valueMerchantId= "${merchantId}"
def valueStoreId= "${storeId}"
def valuePosId= "${posId}"
def valueTrnNo= 12345
def valueRefNo = 11115
def valueAmount= "${amount}"
def valueValidTime = "${validTime}"
def valueSign = "${__property(md5Sign)}"
def field12 = "${}"
def sign = valueLogin + valuePassword + valueMerchantId + valueStoreId + valuePosId + valueTrnNo + valueRefNo + valueAmount + valueValidTime + valueSecret;


jsonMap["login"] = valueLogin
jsonMap["password"] = valuePassword
jsonMap["merchantID"] = valueMerchantId
jsonMap["storeID"] = valueStoreId
jsonMap["posID"] = valuePosId
jsonMap["transactionNo"] = valueTrnNo
jsonMap["referenceNo"] = valueRefNo
jsonMap["amount"] = valueAmount
jsonMap["validTime"] = valueValidTime
jsonMap["secretKey"] = valueSecret
jsonMap["signature"] = valueSign

// Convert JSON data to JSON string
def jsonMapped = JsonOutput.toJson(jsonMap)
def jsonRequestBody = new groovy.json.JsonBuilder(jsonMap).toPrettyString()

def md5Sign = sign.md5()
props.put("md5Sign", md5Sign)
log.info("md5Sign: ${md5Sign}")

// Hash string to MD5 using DigestUtils
def md5Hashhh = DigestUtils.md5Hex(jsonRequestBody)
def md5String = md5Hashhh.toString()
log.info("md5-DigestUtil: ${md5String}")


/*
Create MD5 hash using java.security.MessageDigest
*/
String stringToHash = jsonRequestBody
MessageDigest md = MessageDigest.getInstance("MD5")
md.update(stringToHash.getBytes())
byte[] digest = md.digest()
// Convert the byte array to hexadecimal string
StringBuilder hexString = new StringBuilder()
for (byte b : digest) {
    hexString.append(String.format("%02x", b & 0xff))
}
String md5Hash = hexString.toString()
def md5Hashed = md5Hash 
props.put("md5Hashed",md5Hashed)
log.info("md5-MsgDirect: ${md5Hashed}")

// Convert JSON string to UTF-8 encoded byte array
def utf8Bytes = jsonRequestBody.getBytes("UTF-8")

// Encode UTF-8 encoded byte array to Base64
def base64EncodedString = utf8Bytes.encodeBase64().toString()
props.put("base64EncodedString",base64EncodedString)

//log.info("Mapped JSON: ${jsonMapped}")
log.info("jsonRequestBody: ${jsonRequestBody}")
log.info("SIGNATURE: ${sign}")
log.info("UTF-8: ${utf8Bytes}")
log.info("BASE64: ${base64EncodedString}")


