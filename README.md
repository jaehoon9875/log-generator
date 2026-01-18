# 🚀 Log Generator

> **테스트를 위한 맞춤형 로그 생성 도구**

로그 수집기(Logstash, Fluentd 등) 및 관측성(Observability) 도구의 기능을 검증하기 위해 실제와 유사한 로그를 생성합니다.

---

## ✨ 주요 기능 (Key Features)

*   **다양한 로그 포맷 지원**:
    *   `AppLog` (JSON/Text)
    *   `Syslog` (RFC5424/3164)
    *   `Kafka` 메시지
    *   `OpenSearch` 문서
    *   `Forward` 문서
    *   `TCP/UDP` 문서
*   **Swagger UI 연동**: 별도의 클라이언트 없이 브라우저에서 즉시 로그 생성 명령을 내릴 수 있습니다.
*   **로그 프리셋(Preset) 저장 및 재사용**: 반복적인 테스트 케이스를 조건(TPS, 메시지 패턴 등)으로 저장하고 재사용할 수 있습니다. (개발 예정)
*   **동적 데이터 생성**: `${random_ip}`, `${timestamp}`와 같은 변수를 사용하여 매번 다른 데이터를 포함한 로그를 생성할 수 있습니다. (개발 예정)

---

## 🛠 기술 스택 (Tech Stack)

*   **Language**: Java
*   **Framework**: Spring Boot
*   **API Doc**: Springdoc-openapi (Swagger UI)
*   **Build Tool**: Maven

---

## 🚀 시작하기 (Getting Started)

### 사전 요구사항

*   JDK 17 or higher
*   Maven

### 설치 및 실행

```bash
# Repository Clone
git clone https://github.com/jaehoon9875/log-generator.git

# Build & Run
cd log-generator
./mvnw spring-boot:run
```

### API 접근

애플리케이션 실행 후 아래 주소에서 로그 생성 API를 확인하고 실행할 수 있습니다.

*   **Swagger UI**: `http://localhost:8080/api-doc`

---

## 📖 사용법 (Usage Example)

Swagger UI를 통해 각 Endpoint에 접근하여 로그 생성을 테스트할 수 있습니다.

### 1. Application Log 생성

*   **Endpoint**: `/generate/applog`
*   **설명**: JSON 또는 일반 텍스트 형식의 애플리케이션 로그를 생성합니다.

### 2. Syslog 생성

*   **Endpoint**: `/generate/syslog`
*   **설명**: RFC5424 또는 RFC3164 형식의 Syslog를 생성합니다.

### 3. Kafka 메시지 생성

*   **Endpoint**: `/generate/kafka`
*   **설명**: 지정된 Topic으로 메시지를 전송합니다.

### 4. OpenSearch 문서 생성

*   **Endpoint**: `/generate/opensearch`
*   **설명**: 지정된 Index에 문서를 생성합니다.

---

## 🗺️ 로드맵 (Roadmap)

*   [ ] **프리셋 기능**: 사용자가 정의한 로그 생성 조건을 저장하고 불러오는 기능 구현
*   [ ] **동적 데이터 변수**: 로그 내용에 `${random_ip}`와 같은 변수를 사용하여 동적인 데이터를 생성하는 기능 추가
*   [ ] **UI 개선**: 로그 생성 조건 등을 더 쉽게 관리할 수 있는 별도의 웹 UI 개발
*   [ ] **대규모 생성 성능 개선**: 대량의 로그를 더 빠르고 효율적으로 생성하기 위한 아키텍처 개선

---

## 📄 라이선스 (License)

This project is licensed under the MIT License.
