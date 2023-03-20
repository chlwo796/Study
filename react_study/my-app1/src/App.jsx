import { UseStateEx01 } from "./components2/UseStateEx01";
import { UseEffectEx01 } from "./components2/UseEffectEx01";
import { CssModules } from "./components2/CssModules";
const App = () => {
  // const [ 변수명, 변수를 바꿀 함수명 ] = useState(초기값); //배열분할대입
  return (
    <>
      <div>
        <UseStateEx01></UseStateEx01>
        <UseEffectEx01></UseEffectEx01>
        <CssModules></CssModules>
      </div>
    </>
  );
};
export default App;
