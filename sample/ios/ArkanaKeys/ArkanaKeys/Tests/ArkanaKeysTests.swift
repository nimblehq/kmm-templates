// DO NOT MODIFY
// Automatically generated by Arkana (https://github.com/rogerluan/arkana)

import Foundation
import ArkanaKeysInterfaces
import XCTest
@testable import ArkanaKeys

final class ArkanaKeysTests: XCTestCase {
    private var salt: [UInt8]!
    private var globalSecrets: ArkanaKeysGlobalProtocol!

    override func setUp() {
        super.setUp()
        salt = [
            0xf8, 0x68, 0x3e, 0x2e, 0x5d, 0x8a, 0xc4, 0x5f, 0xb6, 0xa7, 0xc0, 0xa0, 0x51, 0x52, 0x28, 0xb9, 0x5a, 0x7d, 0x26, 0xb0, 0xd4, 0x92, 0x77, 0xc0, 0xfd, 0xed, 0x8c, 0x98, 0x91, 0x58, 0x3b, 0xb5, 0xe6, 0xcc, 0x4f, 0x45, 0xff, 0xd1, 0xf7, 0xb, 0xec, 0x42, 0x6a, 0xb, 0xdb, 0xae, 0xf9, 0xda, 0x28, 0x65, 0x8b, 0xbf, 0xcb, 0x84, 0x54, 0x10, 0x8a, 0xc0, 0x13, 0x17, 0xaf, 0x4d, 0xf5, 0xbf
        ]
        globalSecrets = ArkanaKeys.Global()
    }

    override func tearDown() {
        globalSecrets = nil
        salt = nil
        super.tearDown()
    }

    func test_decodeRandomHexKey_shouldDecode() {
        let encoded: [UInt8] = [
            0x9b, 0xc, 0x9, 0x18, 0x38, 0xee, 0xf3, 0x6f, 0x82, 0x94, 0xf0, 0x91, 0x65, 0x64, 0x1e, 0xda, 0x6e, 0x49, 0x45, 0x82, 0xe6, 0xf6, 0x4f, 0xa5, 0xc9, 0xda, 0xed, 0xa9, 0xa5, 0x6c, 0x58, 0xd1, 0x80, 0xf5, 0x2c, 0x27, 0xcb, 0xe3, 0xc2, 0x6e, 0xd9, 0x23, 0x58, 0x6e, 0xea, 0xcf, 0x9d, 0xe9, 0x4a, 0x6, 0xef, 0x8a, 0xa9, 0xb4, 0x65, 0x23, 0xbc, 0xa3, 0x20, 0x23, 0x9b, 0x7e, 0xc2, 0xde, 0xcb, 0x5c, 0x5a, 0x4a, 0x68, 0xb9, 0xf7, 0x6b, 0x87, 0x94, 0xf0, 0x96, 0x65, 0x64, 0x1a, 0x8f, 0x62, 0x1c, 0x47, 0x86, 0xe7, 0xf7, 0x13, 0xa3, 0xc8, 0x89, 0xbe, 0xa9, 0xf2, 0x6d, 0xc, 0xd7, 0xd0, 0xae, 0x7d, 0x72, 0xc7, 0xb7, 0xcf, 0x69, 0xd5, 0x20, 0x5a, 0x3c, 0xba, 0xca, 0xc8, 0xbf, 0x10, 0x56, 0xed, 0xdc, 0xfa, 0xb1, 0x31, 0x20, 0xb8, 0xf6, 0x77, 0x26, 0xcc, 0x79, 0xc6, 0xdc
        ]
        XCTAssertEqual(ArkanaKeys.decode(encoded: encoded, cipher: salt), "cd76ed704301466c44c22d8e47a144cdf9cb425e5a2e1ad3bcd5b0136c34437a34dd5334130646268aa63edc5d21c57b6b278f8b9b07ad1e83fc15e026d1c43c")
    }

    func test_decodeRandomBase64Key_shouldDecode() {
        let encoded: [UInt8] = [
            0xc8, 0x1a, 0x44, 0x44, 0x2c, 0xb9, 0xb0, 0x3b, 0xc4, 0xf7, 0xf6, 0xf8, 0x60, 0x22, 0x4b, 0x81, 0xd, 0xf, 0x43, 0xe5, 0x81, 0xfb, 0x3e, 0xaf, 0x92, 0x95, 0xcb, 0xe1, 0xe0, 0x3d, 0x57, 0xc0, 0x82, 0xa8, 0x35, 0x3d, 0xad, 0xa8, 0x9d, 0x59, 0x99, 0xb, 0x1c, 0x5b, 0xad, 0xd4, 0xb7, 0x99, 0x51, 0x6, 0xe0, 0xcb, 0xaa, 0xb1, 0x62, 0x7f, 0xcb, 0xae, 0x66, 0x78, 0xc7, 0x7, 0xa3, 0xde, 0x81, 0xb, 0x51, 0x5, 0x36, 0xe7, 0x93, 0x3d, 0xdc, 0xe5, 0x92, 0xeb, 0x21, 0x2a, 0x7d, 0xdf, 0xc, 0x35, 0x70, 0xfa, 0xb9, 0xc3, 0x4a, 0xfd
        ]
        XCTAssertEqual(ArkanaKeys.decode(encoded: encoded, cipher: salt), "0rzjq3tdrP6X1pc8WreUUiIooxGyqeluddzxRyjRuIvPvzNCyckta56oAnuohJVayco+kmWbjBRKpxUfVHVJmQ==")
    }

    func test_decodeUUIDKey_shouldDecode() {
        let encoded: [UInt8] = [
            0x9a, 0xe, 0x5c, 0x16, 0x3e, 0xe8, 0xf0, 0x6f, 0x9b, 0x91, 0xa3, 0x93, 0x33, 0x7f, 0x1c, 0xdb, 0x6a, 0x45, 0xb, 0xd1, 0xe2, 0xa3, 0x16, 0xed, 0x9e, 0x8e, 0xbd, 0xfc, 0xa6, 0x6c, 0x59, 0x8c, 0x82, 0xa8, 0x2e, 0x7d
        ]
        XCTAssertEqual(ArkanaKeys.decode(encoded: encoded, cipher: salt), "bfb8cb40-6c3b-4b08-a61a-cc1d74b9dda8")
    }

    func test_decodeTrueBoolValue_shouldDecode() {
        let encoded: [UInt8] = [
            0x8c, 0x1a, 0x4b, 0x4b
        ]
        XCTAssertTrue(ArkanaKeys.decode(encoded: encoded, cipher: salt))
    }

    func test_decodeFalseBoolValue_shouldDecode() {
        let encoded: [UInt8] = [
            0x9e, 0x9, 0x52, 0x5d, 0x38
        ]
        XCTAssertFalse(ArkanaKeys.decode(encoded: encoded, cipher: salt))
    }

    func test_decodeIntValue_shouldDecode() {
        let encoded: [UInt8] = [
            0xcc, 0x5a
        ]
        XCTAssertEqual(ArkanaKeys.decode(encoded: encoded, cipher: salt), 42)
    }

    func test_encodeAndDecodeValueWithDollarSign_shouldDecode() {
        let encoded: [UInt8] = [
            0x8a, 0xd, 0x5f, 0x42, 0x2, 0xae, 0xa8, 0x36, 0xdb, 0xf8, 0xb3, 0xc8, 0x30, 0x36, 0x51
        ]
        XCTAssertEqual(ArkanaKeys.decode(encoded: encoded, cipher: salt), "real_$lim_shady")
    }
}
